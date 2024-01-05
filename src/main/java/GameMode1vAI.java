import java.awt.*;
import java.awt.event.KeyEvent;

public class GameMode1vAI extends Game{

    Player player;
    AI ai;

    public GameMode1vAI(Graphics2D g, KListener kl, int maxPoints, String playerName){
        super(g, kl, maxPoints);
        Bar playerBar = new Bar(gamePadding,(GameData.gamePaddingH  + (int)(GameData.gamePaddingH/2 + GameData.startHeight/2)) * 3 / 2, GameData.startWidth, GameData.startHeight, GameData.gamePaddingH * 3 / 2, GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        Bar aiBar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, (GameData.gamePaddingH + (int) (GameData.gamePaddingH / 2 + GameData.startHeight / 2)) * 3 / 2, GameData.startWidth, GameData.startHeight, GameData.gamePaddingH * 3 / 2, GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        player = new Player(playerBar, playerName, kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        ai = new AI(aiBar, "CPU", ball);
        player.bar.drawBar(g);
        ai.bar.drawBar(g);
    }

    public void updateGame(Graphics2D g, double dt){
        updateBoard(g);
        if(!pausedGame){
            ball.updateBall(player, ai, score);
            ai.update(dt);
            player.update(dt);
            ball.drawBall(g);
            clock.paused = false;
        }
        else{
            if(maxPoints == score[0]) {
                winnerSign(g, player.playerName);
                Game.curr_user_wins = true;
            }
            else if(maxPoints == score[1]) {
                winnerSign(g, ai.playerName);
                Game.curr_user_wins = false;
            }
            else
                GameData.drawCenteredString(g,"press enter to start", board, Window.fontTitle);
            clock.paused = true;
        }
        sign(g,clock.getTimeString(),result, clockSign, player, ai);
        player.bar.drawBar(g);
        ai.bar.drawBar(g);
    }
}
