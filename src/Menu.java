import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu {

    public static String title = "PONG GAME";
    public static String logged = "user";
    public static String[] titleString = {title,logged};
    public static String[] options = {"PLAY", "TOURNAMENT", "STATS", "USER", "SETTINGS", "EXIT"};

    Font fontTitle = new Font("TimesRoman", Font.PLAIN, (int)(GameData.fontSize * 1.75));
    Font fontSubtitle = new Font("TimesRoman", Font.PLAIN, (int)(GameData.fontSize * 0.75));
    Font fontOption = new Font("TimesRoman", Font.PLAIN, GameData.fontSize);
    Rectangle menuRectTitle = new Rectangle(GameData.menuPaddingW,GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectTitleH);
    Rectangle menuRectSubtitle = new Rectangle(GameData.menuPaddingW,GameData.menuRectTitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectSubtitleH);
    Rectangle menuRectOptions = new Rectangle(GameData.menuPaddingW, GameData.menuRectTitleH + GameData.menuRectSubtitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectOptionH);

    public Menu(){

        /*try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("../bin/baby_blocks.ttf")));
            System.out.println(ge);
        } catch (IOException |FontFormatException e) {
            System.out.println("abcd");
        }*/
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public void drawCenteredArrStrings(Graphics g, String[] text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int arrLen = text.length;
        int tileSize = rect.height / arrLen;
        for(int i = 0; i < arrLen; i++) {
            int x = rect.x + (rect.width - metrics.stringWidth(text[i])) / 2;
            int y = rect.y + ((tileSize - metrics.getHeight()) / 2) + metrics.getAscent() + i * tileSize;
            g.setFont(font);
            g.drawString(text[i], x, y);
        }
    }

    public void drawMenu(Graphics g){
        drawCenteredString(g, title, menuRectTitle, fontTitle);
        drawCenteredString(g, logged, menuRectSubtitle, fontSubtitle);
        drawCenteredArrStrings(g, options, menuRectOptions, fontOption);
    }

    public static void changeLogged(String user){
        logged = "Hello " + user + "!";
        titleString[1] = logged;
        System.out.println(logged);
    }
}
