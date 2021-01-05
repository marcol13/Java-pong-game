import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu {

    public static String title = "PONG GAME";
    public static String logged = "user";
    public static String[] options = {"play", "tournament", "stats", "user", "settings", "exit"};
    public static int currOption = 0;

    //Font fontTitle = new Font("TimesRoman", Font.PLAIN, (int)(GameData.fontSize * 1.75));
    Font fontTitle;
    Font fontSubtitle;
    Font fontOption;
    Rectangle menuRectTitle = new Rectangle(GameData.menuPaddingW,GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectTitleH);
    Rectangle menuRectSubtitle = new Rectangle(GameData.menuPaddingW,GameData.menuRectTitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectSubtitleH);
    Rectangle menuRectOptions = new Rectangle(GameData.menuPaddingW, GameData.menuRectTitleH + GameData.menuRectSubtitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectOptionH);

    public Menu(){

        try {
            fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("bin/baby_blocks.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("bin/baby_blocks.ttf")));
            System.out.println(ge);
            fontSubtitle = new Font("Baby blocks", Font.PLAIN, (int)(GameData.fontSize));
            fontOption = new Font("Baby blocks", Font.PLAIN, (int)(GameData.fontSize * 1.5));
        } catch (IOException |FontFormatException e) {
            Font fontTitle = new Font("TimeRoman", Font.PLAIN, GameData.fontSize * 2);
            Font fontSubtitle = new Font("TimeRoman", Font.PLAIN, (int)(GameData.fontSize * 0.75));
            Font fontOption = new Font("TimeRoman", Font.PLAIN, GameData.fontSize);
        }
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public void drawCenteredArrStrings(Graphics g, String[] text, Rectangle rect, Font font) {
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

    public void drawMenu(Graphics g){
        drawCenteredString(g, title, menuRectTitle, fontTitle);
        drawCenteredString(g, logged, menuRectSubtitle, fontSubtitle);
        drawCenteredArrStrings(g, options, menuRectOptions, fontOption);
    }

    public static void changeLogged(String user){
        logged = "Hello " + user + "!";
        System.out.println(logged);
    }
}
