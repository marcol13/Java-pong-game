import java.awt.*;
import java.util.Random;

public class GameData {
    public static int windowWidth = 800;
    public static int windowHeight = 600;
    public static final String title = "Pong pong pong pong";
    public static int fontSize = (int)((windowWidth * windowWidth) / windowHeight * 0.01875);
    public static int menuPaddingW = 20;
    public static int menuPaddingH = 20;
    public static int gamePaddingW = 20;
    public static int gameSignH = 130;
    public static int gamePaddingH = gamePaddingW + gameSignH;
    public static int gameBoardW = windowWidth - 2 * gamePaddingW;
    public static int gameBoardH = windowHeight - gamePaddingW - gamePaddingH;
    public static int startWidth = (int)(gameBoardW * 0.02);
    public static int startHeight = (int)(gameBoardH * 0.3);
    public static int menuRectTitleH = (int)((windowHeight - (menuPaddingH * 2)) * 0.175);
    public static int menuRectSubtitleH = (int)((windowHeight - (menuPaddingH * 2)) * 0.075);
    public static int menuRectOptionH = windowHeight - (menuPaddingH * 2) - menuRectTitleH - menuRectSubtitleH;

    private static Random rnd = new Random();

    public static int drawSign() {
        if (rnd.nextBoolean())
            return -1;
        return 1;
    }

    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public static void drawCenteredArrStrings(Graphics g, String[] text, Rectangle rect, Font font, int currOption) {
        FontMetrics metrics = g.getFontMetrics(font);
        int arrLen = text.length;
        int tileSize = rect.height / arrLen;
        for(int i = 0; i < arrLen; i++) {
            if(currOption == i)
                g.setColor(Color.RED);
            else
                g.setColor(Color.WHITE);
            int x = rect.x + (rect.width - metrics.stringWidth(text[i])) / 2;
            int y = rect.y + ((tileSize - metrics.getHeight()) / 2) + metrics.getAscent() + i * tileSize;
            g.setFont(font);
            g.drawString(text[i], x, y);
        }
    }
}
