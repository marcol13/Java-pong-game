import java.awt.*;

public class Ball {
    public int size;
    public int x, y, vx, vy;
    private int initX, initY;
    public Color ballColor;

    public Ball(int size, int x, int y, int vx, int vy, Color ballColor){
        this.size = size;
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.vx = vx;
        this.vy = vy;
        this.ballColor = ballColor;
    }

    public void resetBall(){
        x = initX;
        y = initY;
        //VX I VY!
        //Paddle!
    }

    public void drawBall(Graphics2D g){
        g.setColor(ballColor);
        g.fillRect(x, y, size, size);
    }

    //BOTTOM EDGE!
    public void updateBall(PlayerController player1, PlayerController player2, int [] score){
        if(x <= 0 || x + size >= GameData.windowWidth - GameData.gamePaddingW)
            vx = -vx;
        else {
            if (x + vx + size > GameData.windowWidth - GameData.gamePaddingW) {
                vx = -vx;
                score[0]++;
                Game.pausedGame = true;
                resetBall();
            }

            if (x + vx < GameData.gamePaddingW) {
                vx = -vx;
                score[1]++;
                Game.pausedGame = true;
                resetBall();
            }

            if (y + vy + size > GameData.windowHeight - GameData.gamePaddingW || y + vy < GameData.gamePaddingH)
                vy = -vy;
            if (x + vx + size > player2.bar.x && y + vy > player2.bar.y && y + vy <= player2.bar.y + player2.bar.height)
                vx = -vx;
            if (x + vx < player1.bar.x && y + vy > player1.bar.y && y + vy <= player1.bar.y + player1.bar.height)
                vx = -vx;
            this.x += vx;
            this.y += vy;
        }
    }
}
