import java.awt.*;
import java.util.Random;

public class GameData {
    public static int windowWidth = 1920;
    public static int windowHeight = 1080;
    public static final String title = "Pong pong pong pong";
    public static int fontSize = (int)((windowWidth * windowWidth) / windowHeight * 0.01875);
    public static int menuPaddingW = 20;
    public static int menuPaddingH = 20;
    public static int gamePaddingW = 20;
    public static int gameSignH = 130;
    public static int gamePaddingH = gamePaddingW + gameSignH;
    public static int gameBoardW = windowWidth - 2 * gamePaddingW;
    public static int gameBoardH = windowHeight - gamePaddingW - gamePaddingH * 3 / 2;
    public static int gameResultW = (int)(gameBoardH * 0.22);
    public static int gameResultX = (int)(windowWidth / 2 - gameResultW / 2);
    public static int startWidth = (int)(gameBoardW * 0.02);
    public static int startHeight = (int)(gameBoardH * 0.3);
    public static int menuRectTitleH = (int)((windowHeight - (menuPaddingH * 2)) * 0.175);
    public static int menuRectSubtitleH = (int)((windowHeight - (menuPaddingH * 2)) * 0.075);
    public static int menuRectOptionH = windowHeight - (menuPaddingH * 2) - menuRectTitleH - menuRectSubtitleH;

    public static int loginPaddingH = (int)(windowHeight * 0.25);
    public static int loginPaddingW = (int)(windowWidth * 0.25);
    public static int loginRectH = (int)(windowWidth * 0.04);
    public static int loginPaddingRectH = (int)(windowHeight * 0.02);
    public static int loginPaddingRectW = (int)(windowWidth * 0.02);

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

    public static void drawLeftString(Graphics g, String text, Rectangle rect, Font font){
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + 10;
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

    public static void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2){
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.setColor(Color.YELLOW);
        g2d.drawLine(x1, y1, x2, y2);
        g2d.dispose();
    }
}
