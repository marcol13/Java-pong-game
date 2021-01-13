import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    Ball ball;
    Clock clock;
    KListener kl;
    Thread tClock;

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
    public int maxPoints;

    public String mode;

    //mode: {"1v1", "1vAI", "2v2AI"}

    public Game(Graphics2D g, KListener kl, int maxPoints){
        this.maxPoints = maxPoints;
        this.kl = kl;
        ball = new Ball(ballSize,spawnPointX, spawnPointY, GameData.drawSign() * 10, GameData.drawSign() * 10, Color.WHITE);
        board = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, GameData.gameBoardH);
        result = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        clockSign = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW + (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.25));
        clock = new Clock();
        tClock = new Thread(clock);
        ball.drawBall(g);
    }

    public void updateBoard(Graphics2D g){
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.WHITE);
        g.draw(board);
        g.setStroke(oldStroke);
        startGame();
    }

    public void startGame(){
        if(!startGame) {
            if (kl.getKeyPressed(KeyEvent.VK_ENTER) || kl.getKeyPressed(KeyEvent.VK_SPACE)) {
                startGame = true;
                pausedGame = false;
//                clock.run();
                tClock.start();
            }
        }
        if(pausedGame){
            if (kl.getKeyPressed(KeyEvent.VK_ENTER) || kl.getKeyPressed(KeyEvent.VK_SPACE)) {
                pausedGame = false;
            }
        }
    }

    public void sign(Graphics2D g, String timeStr, Rectangle result, Rectangle clockRect, Controller player1, Controller player2){
        Rectangle name1Rect = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW, GameData.gameResultX - GameData.gamePaddingW,(int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        Rectangle name2Rect = new Rectangle( GameData.gameResultX + GameData.gameResultW, GameData.gamePaddingW, GameData.gameResultX - GameData.gamePaddingW,(int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        g.setColor(Color.WHITE);

        GameData.drawCenteredString(g, score[0] + "-" + score[1], result, Window.fontTitle);
        GameData.drawCenteredString(g, player1.playerName, name1Rect, Window.fontTitle);
        GameData.drawCenteredString(g, player2.playerName, name2Rect, Window.fontTitle);
        GameData.drawCenteredString(g,timeStr, clockRect, Window.fontOption);
    }

    public void sign(Graphics2D g, String timeStr, Rectangle result, Rectangle clockRect, Controller player1, Controller player2, Controller player3, Controller player4){
        Rectangle name1Rect = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW, GameData.gameResultX - GameData.gamePaddingW,(int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        Rectangle name2Rect = new Rectangle( GameData.gameResultX + GameData.gameResultW, GameData.gamePaddingW, GameData.gameResultX - GameData.gamePaddingW,(int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        g.setColor(Color.WHITE);

        GameData.drawCenteredString(g,score[0] + "-" + score[1], result, Window.fontTitle);
        GameData.drawCenteredString(g,player1.playerName + ", " + player2.playerName, name1Rect, Window.fontTitle);
        GameData.drawCenteredString(g,player3.playerName + ", " + player4.playerName, name2Rect, Window.fontTitle);
        GameData.drawCenteredString(g,timeStr, clockRect, Window.fontOption);
    }

    public void winnerSign(Graphics2D g, String winner){
        Rectangle winnerRect = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, (int)(GameData.gameBoardH * 0.75));
        g.setColor(Color.WHITE);

        GameData.drawCenteredString(g, winner.substring(0,1).toUpperCase() + winner.substring(1) + " wins!", winnerRect, Window.fontTitle);
    }

}
