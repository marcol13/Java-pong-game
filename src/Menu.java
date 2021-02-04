import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu {

    public static String title = "PONG GAME";
    public static String logged = "user";
    public static String[] options = {"play", "tournament", "stats", "user", "settings", "exit"};
    public static int currOption = 0;

    //Font fontTitle = new Font("TimesRoman", Font.PLAIN, (int)(GameData.fontSize * 1.75));

    Rectangle menuRectTitle = new Rectangle(GameData.menuPaddingW,GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectTitleH);
    Rectangle menuRectSubtitle = new Rectangle(GameData.menuPaddingW,GameData.menuRectTitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectSubtitleH);
    Rectangle menuRectOptions = new Rectangle(GameData.menuPaddingW, GameData.menuRectTitleH + GameData.menuRectSubtitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectOptionH);

    MyFrame frame;

    public Menu(Graphics g, MyFrame frame){
        this.frame = frame;
        drawMenu(g);

    }

    public void drawMenu(Graphics g){
        GameData.drawCenteredString(g, title, menuRectTitle, Window.fontTitle);
        GameData.drawCenteredString(g, logged, menuRectSubtitle, Window.fontSubtitle);
        GameData.drawCenteredArrStrings(g, options, menuRectOptions, Window.fontSecond, currOption);
        buttons();
    }

    public void buttons(){
        JButton button = new JButton("abcd");
        frame.add(button);
    }

    public static void changeLogged(String user){
        logged = "Hello " + user + "!";
        System.out.println(logged);
    }
}
