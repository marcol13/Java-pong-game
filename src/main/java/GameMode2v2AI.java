import java.awt.*;
import java.awt.event.KeyEvent;

public class GameMode2v2AI extends Game{

    Player player1;
    Player player2;
    AI ai1;
    AI ai2;

    public GameMode2v2AI(Graphics2D g, KListener kl, int maxPoints, String playerName1, String playerName2){
        super(g, kl, maxPoints);
        Bar player1Bar = new Bar(gamePadding,(GameData.gamePaddingH + (int)(GameData.gamePaddingH/4 + GameData.startHeight/4)) * 3 / 2, (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), GameData.gamePaddingH * 3 / 2, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH * 3 / 2), Color.WHITE);
        Bar player2Bar = new Bar(gamePadding,(GameData.gamePaddingH + (int)(GameData.gamePaddingH + GameData.startHeight)) * 3 / 2, (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH * 3 / 2), GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        Bar ai1Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, (GameData.gamePaddingH + (int) (GameData.gamePaddingH / 4 + GameData.startHeight / 4)) * 3 / 2, (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), GameData.gamePaddingH * 3 / 2, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH * 3 / 2), Color.WHITE);
        Bar ai2Bar = new Bar(GameData.windowWidth - gamePadding - GameData.startWidth, (GameData.gamePaddingH + (int) (GameData.gamePaddingH + GameData.startHeight)) * 3 / 2, (int)(GameData.startWidth * 0.75), (int)(GameData.startHeight * 0.75), (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH * 3 / 2), GameData.windowHeight - GameData.gamePaddingW, Color.WHITE);
        player1 = new Player(player1Bar, playerName1, kl, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        player2 = new Player(player2Bar, playerName2, kl, KeyEvent.VK_W, KeyEvent.VK_S);
        ai1 = new AI(ai1Bar, "CPU1", ball);
        ai2 = new AI(ai2Bar, "CPU2", ball);
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
        ai1.bar.drawBar(g);
        ai2.bar.drawBar(g);
    }

    public void updateGame(Graphics2D g, double dt){
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
            if(maxPoints == score[0]) {
                winnerSign(g, player1.playerName + " " + player2.playerName);
                Game.curr_user_wins = true;
            }
            else if(maxPoints == score[1]) {
                winnerSign(g, ai1.playerName + " " + ai2.playerName);
                Game.curr_user_wins = false;
            }
            else
                GameData.drawCenteredString(g,"press enter to start", new Rectangle(GameData.gamePaddingW, GameData.gamePaddingH, GameData.gameBoardW, (int)(GameData.gameBoardH / 2)), Window.fontTitle);
            clock.paused = true;
        }
        sign(g, clock.getTimeString(), result, clockSign, player1, player2, ai1, ai2);
        GameData.drawDashedLine(g, GameData.gamePaddingW, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH * 3 / 2),GameData.windowWidth - GameData.gamePaddingW, (int)(GameData.gameBoardH / 2 + GameData.gamePaddingH * 3 / 2));
        player1.bar.drawBar(g);
        player2.bar.drawBar(g);
        ai1.bar.drawBar(g);
        ai2.bar.drawBar(g);
    }
}
