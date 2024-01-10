import java.awt.*;
import java.io.IOException;


public class Window{

    Graphics2D graphics2D;

    public static Menu menu;
    public static LoginForm login;
    public static MyFrame myFrame;
    public static PlayerStats stats;
    public static PlaySettings playSettings;
    public static TournamentChoose tournamentChoose;
    public static CreateTournament createTournament;
    public static Tournament tournament;
    public static Congratulation congratulation;
    public static LoadWindow loadWindow;

    public static Font fontTitle;
    public static Font fontSubtitle;
    public static Font fontOption;
    public static Font fontSecond;
    public static Font fontSecondSmall;

    public static String curr_user;
    public static ClassLoader classLoader = Window.class.getClassLoader();
    public static String [] userInfo;
    public static String [] pass;

    int fps;
    public static int players;
    public static int statsPage;
    public static int gameModeInt;

    public Window(){
        myFrame = new MyFrame();
        this.fps = 30;
        curr_user = "Guest";
        statsPage = 0;
        gameModeInt = 0;

        try {
            fontTitle = Font.createFont(Font.TRUETYPE_FONT, Window.classLoader.getResourceAsStream("baby_blocks.ttf")).deriveFont(80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Window.classLoader.getResourceAsStream("baby_blocks.ttf")));

            fontSecond = Font.createFont(Font.TRUETYPE_FONT, Window.classLoader.getResourceAsStream("dogica.otf")).deriveFont(40f);
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Window.classLoader.getResourceAsStream("dogica.otf")));

            fontSubtitle = new Font("Baby blocks", Font.PLAIN, (int)(GameData.fontSize));
            fontOption = new Font("Baby blocks", Font.PLAIN, (int)(GameData.fontSize * 0.6));
            fontSecondSmall = new Font("Dogica", Font.PLAIN, (int)(GameData.fontSize * 0.4));
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }

        graphics2D = (Graphics2D)myFrame.getGraphics();
        menu = new Menu(myFrame);
    }

    public static void updatePlayers(){
        players = PlayerInfo.users_quantity(Window.classLoader.getResourceAsStream("data/users.txt")) / 4;
        userInfo = new String[players * 3];
        pass = new String[players];
        PlayerInfo.getPlayerInfo(Window.classLoader.getResourceAsStream("data/users.txt"));
    }
}
