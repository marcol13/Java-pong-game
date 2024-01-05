import java.awt.*;

public class OptionRect extends Rectangle {

    public Color color;

    public OptionRect(int x, int y, int width, int height, Color color){
        super(x, y, width, height);
        this.color = color;
    }

    public void drawRect(Graphics2D g){
        g.setColor(color);
        g.draw(this);
    }
}
