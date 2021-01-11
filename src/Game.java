import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    Player player1;
    Player player2;
    AI ai1;
    AI ai2;
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

    public String mode;

    //mode: {"1v1", "1vAI", "2v2AI"}

    //1V1
    public Game(Graphics2D g, KListener kl, String mode){
        ball = new Ball(ballSize,spawnPointX, spawnPointY, GameData.drawSign() * 2, GameData.drawSign() * 2, Color.WHITE);
        board = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, GameData.gameBoardH);
        result = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW);
        clock = new Rectangle(GameData.gamePaddingW, GameData.gamePaddingW + (int)(GameData.gameSignH * 0.75) - GameData.gamePaddingW, GameData.gameBoardW, (int)(GameData.gameSignH * 0.25));
        this.mode = mode;

        switch (mode) {
            case "1v1" -> {
                Bar player1Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, Color.WHITE);
                Bar player2Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, GameData.gamePaddingH + (int) (GameData.gamePaddingH / 2 + GameData.startHeight / 2), GameData.startWidth, GameData.startHeight, Color.WHITE);
                player1 = new Player(player1Bar, "unknown", kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
                player2 = new Player(player2Bar, "gregory", kl, KeyEvent.VK_W, KeyEvent.VK_S);
                player1.bar.drawBar(g);
                player2.bar.drawBar(g);
            }
            case "1vAI" -> {
                Bar player1Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, Color.WHITE);
                Bar ai1Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, GameData.gamePaddingH + (int) (GameData.gamePaddingH / 2 + GameData.startHeight / 2), GameData.startWidth, GameData.startHeight, Color.WHITE);
                player1 = new Player(player1Bar, "unknown", kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
                ai1 = new AI(ai1Bar, "cpu", ball);
                player1.bar.drawBar(g);
                ai1.bar.drawBar(g);
            }
            case "2v2AI" -> {
                Bar player1Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/4 + GameData.startHeight/4), (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), Color.WHITE);
                Bar player2Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH + GameData.startHeight), (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), Color.WHITE);
                player1 = new Player(player1Bar, "unknown", kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
                player2 = new Player(player2Bar, "gregory", kl, KeyEvent.VK_W, KeyEvent.VK_S);
                player1.bar.drawBar(g);
                player2.bar.drawBar(g);
            }
            default -> throw new RuntimeException("Incorrect game mode");
        }

        ball.drawBall(g);
    }

    public void updateGame(Graphics2D g, double dt, Clock clock){
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.WHITE);
        g.draw(board);
        g.setStroke(oldStroke);


        if(!pausedGame) {
            switch (mode) {
                case "1v1" -> {
                    ball.updateBall(player1, player2, score);
                    player2.update(dt);
                }
                case "1vAI" -> {
                    ball.updateBall(player1, ai1, score);
                    ai1.update(dt);
                }
                case "2v2AI" -> {
                    ball.updateBall(player1, player2, score);
                    player2.update(dt);
                }
            }
            player1.update(dt);
            ball.drawBall(g);
            clock.paused = false;
        }
        else{
            GameData.drawCenteredString(g,"press enter to start", board, Window.fontTitle);
            clock.paused = true;
        }

        switch (mode) {
            case "1v1" -> {
                sign(g,clock.getTimeString(),player2);
                player1.bar.drawBar(g);
                player2.bar.drawBar(g);
            }
            case "1vAI" -> {
                sign(g,clock.getTimeString(),ai1);
                player1.bar.drawBar(g);
                ai1.bar.drawBar(g);
            }
            case "2v2AI" -> {
                GameData.drawDashedLine(g, GameData.gamePaddingW, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH),GameData.windowWidth - GameData.gamePaddingW, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH));
                player1.bar.drawBar(g);
                player2.bar.drawBar(g);
            }
        }
    }

    public void sign(Graphics2D g, String time, Controller player){
        //String topSign = player1.playerName + "   " + score[0] + "-" + score[1] + "   " + player2.playerName;
        String topSign = player1.playerName + "   " + score[0] + "-" + score[1] + "   " + player.playerName;
        //temp
        String clockSign = time;
        g.setColor(Color.WHITE);
        GameData.drawCenteredString(g,topSign, result, Window.fontTitle);
        GameData.drawCenteredString(g,clockSign, clock, Window.fontOption);
    }

}
