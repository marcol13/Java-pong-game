import java.awt.*;

public class Ball {
    public int size;
    public int x, y, vx, vy;
    private int initX, initY;
    private int initVX, initVY;
    public Color ballColor;

    public Ball(int size, int x, int y, int vx, int vy, Color ballColor){
        this.size = size;
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.vx = vx;
        this.vy = vy;
        this.initVX = vx;
        this.initVY = vy;
        this.ballColor = ballColor;
    }

    public void resetBall(){
        x = initX;
        y = initY;
        vx = initVX;
        vy = initVY;
        //Paddle!
    }

    public void drawBall(Graphics2D g){
        g.setColor(ballColor);
        g.fillRect(x, y, size, size);
    }

    public int getMiddle(){
        return (int)(size / 2 + y);
    }

    //BOTTOM EDGE!
    public void updateBall(Controller player1, Controller player2, int [] score){
        if(x <= 0 || x + size >= GameData.windowWidth - GameData.gamePaddingW)
            vx = -vx;
        else {
            if (x + vx + size > GameData.windowWidth - GameData.gamePaddingW * 3 / 2) {
                vx = -vx;
                score[0]++;
                Game.pausedGame = true;
                resetBall();
                player1.bar.resetBar();
                player2.bar.resetBar();
            }

            if (x + vx < GameData.gamePaddingW) {
                vx = -vx;
                score[1]++;
                Game.pausedGame = true;
                resetBall();
                player1.bar.resetBar();
                player2.bar.resetBar();
            }

            if (y + vy + size > GameData.windowHeight - GameData.gamePaddingW || y + vy < GameData.gamePaddingH * 3 / 2)
                vy = -vy;
            if (x + vx + size > player2.bar.x && y + vy > player2.bar.y && y + vy <= player2.bar.y + player2.bar.height) {
                vx++;
                vx = -vx;
                if(GameData.drawSign() == -1) {
                    if (vy > 0)
                        vy++;
                    else
                        vy--;
                }
            }
            if (x + vx < player1.bar.x + player1.bar.width && y + vy > player1.bar.y && y + vy <= player1.bar.y + player1.bar.height) {
                vx = -vx;
                vx++;
                if(GameData.drawSign() == -1) {
                    if (vy > 0)
                        vy++;
                    else
                        vy--;
                }
            }
            this.x += vx;
            this.y += vy;
        }
    }

    public void updateBall(Controller player1, Controller player2, Controller player3, Controller player4, int [] score){
        if(x <= 0 || x + size >= GameData.windowWidth - GameData.gamePaddingW)
            vx = -vx;
        else {
            if (x + vx + size > GameData.windowWidth - GameData.gamePaddingW) {
                vx = -vx;
                score[0]++;
                Game.pausedGame = true;
                resetBall();
                player1.bar.resetBar();
                player2.bar.resetBar();
                player3.bar.resetBar();
                player4.bar.resetBar();
            }

            if (x + vx < GameData.gamePaddingW) {
                vx = -vx;
                score[1]++;
                Game.pausedGame = true;
                resetBall();
                player1.bar.resetBar();
                player2.bar.resetBar();
                player3.bar.resetBar();
                player4.bar.resetBar();
            }

            if (y + vy + size > GameData.windowHeight - GameData.gamePaddingW || y + vy < GameData.gamePaddingH * 3 / 2)
                vy = -vy;
            if ((x + vx + size > player3.bar.x && y + vy > player3.bar.y && y + vy <= player3.bar.y + player3.bar.height) || (x + vx + size > player4.bar.x && y + vy > player4.bar.y && y + vy <= player4.bar.y + player4.bar.height)) {
                vx++;
                vx = -vx;
                if(GameData.drawSign() == -1) {
                    if (vy > 0)
                        vy++;
                    else
                        vy--;
                }
            }
            if ((x + vx < player1.bar.x + player1.bar.width && y + vy > player1.bar.y && y + vy <= player1.bar.y + player1.bar.height) || (x + vx < player2.bar.x + player2.bar.width && y + vy > player2.bar.y && y + vy <= player2.bar.y + player2.bar.height)){
                vx = -vx;
                vx++;
                if(GameData.drawSign() == -1) {
                    if (vy > 0)
                        vy++;
                    else
                        vy--;
                }
            }
            this.x += vx;
            this.y += vy;
        }
    }
}
