import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu {

    public static String title = "PONG GAME";
    public static String logged = "user";
    public static String[] titleString = {title,logged};
    public static String[] options = {"PLAY", "TOURNAMENT", "STATS", "USER", "SETTINGS", "EXIT"};

    public Menu(){

        /*try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("../bin/baby_blocks.ttf")));
            System.out.println(ge);
        } catch (IOException |FontFormatException e) {
            System.out.println("abcd");
        }*/
    }

    public static void changeLogged(String user){
        logged = "Hello " + user + "!";
        titleString[1] = logged;
        System.out.println(logged);
    }
}
