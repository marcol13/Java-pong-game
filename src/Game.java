import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    PlayerController player1;
    PlayerController player2;
    Ball ball;

    public int score[] = new int[2];
    public int gameBoardW = GameData.windowWidth - 2 * GameData.gamePaddingW;
    public int gameBoardH = GameData.windowHeight - GameData.gamePaddingW - GameData.gamePaddingH;
    public Rectangle board;
    public int startWidth = 20;
    public int startHeight = 200;
    public int gamePadding = 30;
    public int ballSize = 10;
    public int spawnPointX = (int)((GameData.windowWidth - ballSize)/2);
    public int spawnPointY = (int)((GameData.windowHeight - ballSize) / 2);


    //1V1
    public Game(Graphics2D g, KListener kl){
        Bar player1Bar = new Bar(gamePadding,0, startWidth, startHeight, Color.WHITE);
        Bar player2Bar = new Bar(GameData.windowWidth - gamePadding - startWidth,0, startWidth, startHeight, Color.WHITE);
        player1 = new PlayerController(player1Bar, kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        player2 = new PlayerController(player2Bar, kl, KeyEvent.VK_W, KeyEvent.VK_S);
        board = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, gameBoardW, gameBoardH);
        ball = new Ball(ballSize,spawnPointX, spawnPointY, 10, 5, Color.WHITE);
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
        ball.updateBall(player1, player2);
        player1.update(dt);
        player2.update(dt);
        ball.drawBall(g);
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
    }

}
