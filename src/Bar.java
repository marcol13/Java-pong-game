import java.awt.*;

public class Bar {
    public int x, y, width, height;
    private int initX, initY;
    Color barColor;

    public Bar(int x, int y, int width, int height, Color barColor){
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.width = width;
        this.height = height;
        this.barColor = barColor;
    }

    public void drawBar(Graphics2D g){
        g.setColor(barColor);
        g.fillRect(x,y,width,height);
    }

    public void moveBar(int dy){
        if(y + dy > GameData.gamePaddingH && y + dy + height < GameData.windowHeight - GameData.gamePaddingW)
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
