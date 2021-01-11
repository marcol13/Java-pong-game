import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    Player player1;
    //Player player2;
    AI ai;
    Ball ball;

    public int score[] = new int[2];

    public Rectangle board;
    public Rectangle result;
    public Rectangle clock;

    boolean startGame = false;
    public static boolean pausedGame = true;

    public int gamePadding = 30;
    public int ballSize = 10;
    public int spawnPointX = (int)((GameData.gameBoardW - ballSize)/2) + gamePadding;
    public int spawnPointY = (int)((GameData.gameBoardH - ballSize) / 2) + GameData.gamePaddingH;


    //1V1
    public Game(Graphics2D g, KListener kl){
        Bar player1Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, Color.WHITE);
        //Bar player2Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, Color.WHITE);
        Bar player2Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, Color.WHITE);
        ball = new Ball(ballSize,spawnPointX, spawnPointY, GameData.drawSign() * 2, GameData.drawSign() * 2, Color.WHITE);
        player1 = new Player(player1Bar, "unknown", kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        //player2 = new Player(player2Bar, "gregory", kl, KeyEvent.VK_W, KeyEvent.VK_S);
        ai = new AI(player2Bar, "cpu", ball);
        board = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, GameData.gameBoardH);
        result = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        clock = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW + (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.25));

        ball.drawBall(g);
        player1.bar.drawBar(g);
        //player2.bar.drawBar(g);
        ai.bar.drawBar(g);
    }

    public void updateGame(Graphics2D g, double dt, Clock clock){
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.WHITE);
        g.draw(board);
        g.setStroke(oldStroke);
        sign(g,clock.getTimeString());
        if(!pausedGame) {
            //ball.updateBall(player1, player2, score);
            ball.updateBall(player1, ai, score);
            player1.update(dt);
            //player2.update(dt);
            ai.update(dt);
            ball.drawBall(g);
            clock.paused = false;
        }
        else{
            GameData.drawCenteredString(g,"press enter to start", board, Window.fontTitle);
            clock.paused = true;
        }
        player1.bar.drawBar(g);
        //player2.bar.drawBar(g);
        ai.bar.drawBar(g);

    }

    public void resetBall(Graphics2D g, String time){

    }

    public void sign(Graphics2D g, String time){
        //String topSign = player1.playerName + "   " + score[0] + "-" + score[1] + "   " + player2.playerName;
        String topSign = player1.playerName + "   " + score[0] + "-" + score[1] + "   " + ai.playerName;
        //temp
        String clockSign = time;
        g.setColor(Color.WHITE);
        GameData.drawCenteredString(g,topSign, result, Window.fontTitle);
        GameData.drawCenteredString(g,clockSign, clock, Window.fontOption);
    }

}
