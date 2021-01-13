import java.awt.*;
import java.awt.event.KeyEvent;

public class GameMode2v2AI extends Game{

    Player player1;
    Player player2;
    AI ai1;
    AI ai2;

    public GameMode2v2AI(Graphics2D g, KListener kl){
        super(g, kl);
        Bar player1Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/4 + GameData.startHeight/4), (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), GameData.gamePaddingH, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH), Color.WHITE);
        Bar player2Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH + GameData.startHeight), (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH), GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        Bar ai1Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, GameData.gamePaddingH + (int) (GameData.gamePaddingH / 4 + GameData.startHeight / 4), (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), GameData.gamePaddingH, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH), Color.WHITE);
        Bar ai2Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, GameData.gamePaddingH + (int) (GameData.gamePaddingH + GameData.startHeight), (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH), GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        player1 = new Player(player1Bar, "unknown", kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        player2 = new Player(player2Bar, "gregory", kl, KeyEvent.VK_W, KeyEvent.VK_S);
        ai1 = new AI(ai1Bar, "cpu1", ball);
        ai2 = new AI(ai2Bar, "cpu2", ball);
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
        ai1.bar.drawBar(g);
        ai2.bar.drawBar(g);
    }

    public void updateGame(Graphics2D g, double dt, Clock clock){
        updateBoard(g);
        if(!pausedGame){
            ball.updateBall(player1, player2, ai1, ai2, score);
            player1.update(dt);
            player2.update(dt);
            ai1.update(dt);
            ai2.update(dt);
            ball.drawBall(g);
            clock.paused = false;
        }
        else{
            GameData.drawCenteredString(g,"press enter to start", new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, (int)(GameData.gameBoardH / 2)), Window.fontTitle);
            clock.paused = true;
        }
        sign(g, clock.getTimeString(), result, clockSign, player1, player2, ai1, ai2);
        GameData.drawDashedLine(g, GameData.gamePaddingW, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH),GameData.windowWidth - GameData.gamePaddingW, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH));
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
        ai1.bar.drawBar(g);
        ai2.bar.drawBar(g);
    }
}
