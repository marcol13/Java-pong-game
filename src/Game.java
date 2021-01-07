import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    PlayerController player1;
    PlayerController player2;
    Ball ball;

    public int score[] = new int[2];

    public Rectangle board;
    public Rectangle result;
    public Rectangle clock;

    public int gamePadding = 30;
    public int ballSize = 10;
    public int spawnPointX = (int)((GameData.gameBoardW - ballSize)/2) + gamePadding;
    public int spawnPointY = (int)((GameData.gameBoardH - ballSize) / 2) + GameData.gamePaddingH;


    //1V1
    public Game(Graphics2D g, KListener kl){
        Bar player1Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, Color.WHITE);
        Bar player2Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, Color.WHITE);
        player1 = new PlayerController(player1Bar, kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN, "unknown");
        player2 = new PlayerController(player2Bar, kl, KeyEvent.VK_W, KeyEvent.VK_S, "gregory");
        board = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, GameData.gameBoardH);
        result = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.75));
        clock = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW + (int)(GameData.gameSignH * 0.75), GameData.gameBoardW, (int)(GameData.gameSignH * 0.25));
        ball = new Ball(ballSize,spawnPointX, spawnPointY, GameData.drawSign() * 10, GameData.drawSign() * 5, Color.WHITE);
        ball.drawBall(g);
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
    }

    public void updateGame(Graphics2D g, double dt){
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.WHITE);
        g.draw(board);
        g.setStroke(oldStroke);
        sign(g,dt);
        ball.updateBall(player1, player2);
        player1.update(dt);
        player2.update(dt);
        ball.drawBall(g);
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
    }

    public void sign(Graphics2D g, double dt){
        String topSign = player1.playerName + "   " + score[0] + ":" + score[1] + "   " + player2.playerName;
        //temp
        String clockSign = "00:00";
        g.setColor(Color.WHITE);
        GameData.drawCenteredString(g,topSign, result, Window.fontTitle);
        GameData.drawCenteredString(g,clockSign, clock, Window.fontOption);
    }

}
