import java.awt.*;
import java.awt.event.KeyEvent;

public class GameMode1vAI extends Game{

    Player player;
    AI ai;

    public GameMode1vAI(Graphics2D g, KListener kl){
        super(g, kl);
        Bar playerBar = new Bar(gamePadding,GameData.gamePaddingH + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2), GameData.startWidth, GameData.startHeight, GameData.gamePaddingH, GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        Bar aiBar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, GameData.gamePaddingH + (int) (GameData.gamePaddingH / 2 + GameData.startHeight / 2), GameData.startWidth, GameData.startHeight, GameData.gamePaddingH, GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        player = new Player(playerBar, "unknown", kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        ai = new AI(aiBar, "cpu", ball);
        player.bar.drawBar(g);
        ai.bar.drawBar(g);
    }

    public void updateGame(Graphics2D g, double dt, Clock clock){
        updateBoard(g);
        if(!pausedGame){
            ball.updateBall(player, ai, score);
            ai.update(dt);
            player.update(dt);
            ball.drawBall(g);
            clock.paused = false;
        }
        else{
            GameData.drawCenteredString(g,"press enter to start", board, Window.fontTitle);
            clock.paused = true;
        }
        sign(g,clock.getTimeString(),result, clockSign, player, ai);
        player.bar.drawBar(g);
        ai.bar.drawBar(g);
    }
}
