import java.awt.*;
import java.awt.event.KeyEvent;

public class GameMode1v1 extends Game{

    Player player1;
    Player player2;

    public GameMode1v1(Graphics2D g, KListener kl){
        super(g,kl);
        Bar player1Bar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, GameData.gamePaddingH,  GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        Bar player2Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, GameData.gamePaddingH + (int) (GameData.gamePaddingH / 2 + GameData.startHeight / 2), GameData.startWidth, GameData.startHeight, GameData.gamePaddingH, GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        player1 = new Player(player1Bar, "unknown", kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        player2 = new Player(player2Bar, "gregory", kl, KeyEvent.VK_W, KeyEvent.VK_S);
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
    }

    public void updateGame(Graphics2D g, double dt){
        updateBoard(g);
        if(!pausedGame) {
            ball.updateBall(player1, player2, score);
            player1.update(dt);
            player2.update(dt);
            ball.drawBall(g);
            clock.paused = false;
        }
        else{
            GameData.drawCenteredString(g,"press enter to start", board, Window.fontTitle);
            clock.paused = true;
        }
        sign(g,clock.getTimeString(), result, clockSign, player1, player2);
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
    }
}
