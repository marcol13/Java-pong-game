import java.awt.*;

public class Bar {
    private int x, y, width, height;
    Color barColor;

    public Bar(int x, int y, int width, int height, Color barColor){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.barColor = barColor;
    }

    public void drawBar(Graphics2D g){
        g.setColor(barColor);
        g.fillRect(x,y,width,height);
    }

    public void moveBar(int dy){
        if(y + dy > 0 && y + dy + height < GameData.windowHeight)
            this.y += dy;
    }

}
