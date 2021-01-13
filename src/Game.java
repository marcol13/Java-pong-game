import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    Ball ball;

    public int score[] = new int[2];

    public Rectangle board;
    public Rectangle result;
    public Rectangle clockSign;

    boolean startGame = false;
    public static boolean pausedGame = true;

    public int gamePadding = 30;
    public int ballSize = 10;
    public int spawnPointX = (int)((GameData.gameBoardW - ballSize)/2) + gamePadding;
    public int spawnPointY = (int)((GameData.gameBoardH - ballSize) / 2) + GameData.gamePaddingH;

    public String mode;

    //mode: {"1v1", "1vAI", "2v2AI"}

    //1V1
    public Game(Graphics2D g, KListener kl){
        ball = new Ball(ballSize,spawnPointX, spawnPointY, GameData.drawSign() * 2, GameData.drawSign() * 2, Color.WHITE);
        board = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, GameData.gameBoardH);
        result = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        clockSign = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW + (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.25));
        ball.drawBall(g);
    }

    public void updateBoard(Graphics2D g){
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.WHITE);
        g.draw(board);
        g.setStroke(oldStroke);
    }

    public void sign(Graphics2D g, String time, Rectangle result, Rectangle clock, Controller player1, Controller player2){
        //String topSign = player1.playerName + "   " + score[0] + "-" + score[1] + "   " + player2.playerName;
        String topSign = player1.playerName + "   " + score[0] + "-" + score[1] + "   " + player2.playerName;
        //temp
        String clockSign = time;
        g.setColor(Color.WHITE);
        GameData.drawCenteredString(g,topSign, result, Window.fontTitle);
        GameData.drawCenteredString(g,clockSign, clock, Window.fontOption);
    }

    public void sign(Graphics2D g, String time, Rectangle result, Rectangle clock, Controller player1, Controller player2, Controller player3, Controller player4){
        //String topSign = player1.playerName + "   " + score[0] + "-" + score[1] + "   " + player2.playerName;
        String topSign = player1.playerName + ", " + player2.playerName + "   " + score[0] + "-" + score[1] + "   " + player3.playerName + ", " + player4.playerName;
        //temp
        String clockSign = time;
        g.setColor(Color.WHITE);
        GameData.drawCenteredString(g,topSign, result, Window.fontTitle);
        GameData.drawCenteredString(g,clockSign, clock, Window.fontOption);
    }

}
