import java.awt.*;

public class Bar {
    public int x, y, width, height;
    private final int initX;
    private final int initY;
    private final int upLimit;
    private final int downLimit;
    Color barColor;

    public Bar(int x, int y, int width, int height, int upLimit, int downLimit, Color barColor){
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.width = width;
        this.height = height;
        this.upLimit = upLimit;
        this.downLimit = downLimit;
        this.barColor = barColor;
    }

    public void drawBar(Graphics2D g){
        g.setColor(barColor);
        g.fillRect(x,y,width,height);
    }

    public void moveBar(int dy){
        if(y + dy > upLimit && y + dy + height < downLimit)
            this.y += dy;
    }

    public int getMiddle(){
        return (int)(height / 2 + y);
    }

    public void resetBar(){
        x = initX;
        y = initY;
    }

}
