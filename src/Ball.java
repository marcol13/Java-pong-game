import java.awt.*;

public class Ball {
    public int size;
    public int x, y, vx, vy;
    public Color ballColor;

    public Ball(int size, int x, int y, int vx, int vy, Color ballColor){
        this.size = size;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void drawBall(Graphics2D g){
        g.setColor(ballColor);
        g.fillRect(x, y, size, size);
    }
}
