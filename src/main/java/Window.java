import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


public class Window{

//    GameMode1v1 game;
//    GameMode1vAI game;
//    GameMode2v2AI game;
//    Clock clock;
    Graphics2D g;

    Users user = new Users();
    public static Menu menu;
    public static LoginForm login;
    public static MyFrame myFrame;
    public static PlayerStats stats;
    public static PlaySettings playSettings;
    public static TournamentChoose tournamentChoose;
    public static CreateTournament createTournament;
//    public static TournamentTable tournamentTable;
    public static Tournament tournament;
    public static Congratulation congratulation;
    public static LoadWindow loadWindow;

    public static Font fontTitle;
    public static Font fontSubtitle;
    public static Font fontOption;
    public static Font fontSecond;
    public static Font fontSecondSmall;

    public static String curr_user;
    public static String jar_path = "../../../";
    public static String [] userInfo;
    public static String [] pass;

    int fps;
    public static int players;
    public static int statsPage;
    public static int gameModeInt;

    public Window(){
        //Dodać fullscreen
        myFrame = new MyFrame();
        this.fps = 30;
        curr_user = "Guest";
        statsPage = 0;
        gameModeInt = 0;

        try {
            fontTitle = Font.createFont(Font.TRUETYPE_FONT, new File("bin/baby_blocks.ttf")).deriveFont(80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("bin/baby_blocks.ttf")));

            fontSecond = Font.createFont(Font.TRUETYPE_FONT, new File("bin/dogica.otf")).deriveFont(40f);
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("bin/dogica.otf")));

            fontSubtitle = new Font("Baby blocks", Font.PLAIN, (int)(GameData.fontSize));
            fontOption = new Font("Baby blocks", Font.PLAIN, (int)(GameData.fontSize * 0.6));
            fontSecondSmall = new Font("Dogica", Font.PLAIN, (int)(GameData.fontSize * 0.4));
        } catch (IOException |FontFormatException e) {
            Font fontTitle = new Font("TimeRoman", Font.PLAIN, GameData.fontSize * 2);
            Font fontSubtitle = new Font("TimeRoman", Font.PLAIN, (int)(GameData.fontSize * 0.75));
            Font fontOption = new Font("TimeRoman", Font.PLAIN, GameData.fontSize);
        }

        g = (Graphics2D)myFrame.getGraphics();
        menu = new Menu(myFrame);
        //menu.changeLogged(user.getCurrUser());

        //game = new GameMode1v1(g, kl, 2);
//        login = new LoginForm(g, MyFrame.kl, myFrame);
        //game = new GameMode1vAI(g,kl);
        //game = new GameMode2v2AI(g,kl);
//        clock = new Clock();
//        Thread tClock = new Thread(clock);
    }

    public static void updatePlayers(){
        players = PlayerInfo.users_quantity("bin/data/users.txt") / 4;
        userInfo = new String[players * 3];
        pass = new String[players];
        PlayerInfo.getPlayerInfo("bin/data/users.txt");
    }




}
