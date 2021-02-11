import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu {

    public static String title = "PONG GAME";
    public static String logged = "guest";
    public static String[] options = {"play", "tournament", "stats", "user", "exit"};
    public static int currOption = 0;

    //Font fontTitle = new Font("TimesRoman", Font.PLAIN, (int)(GameData.fontSize * 1.75));

    Rectangle menuRectTitle = new Rectangle(GameData.menuPaddingW,GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectTitleH);
    Rectangle menuRectSubtitle = new Rectangle(GameData.menuPaddingW,GameData.menuRectTitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectSubtitleH);
    Rectangle menuRectOptions = new Rectangle(0, GameData.menuRectTitleH + GameData.menuRectSubtitleH + GameData.menuPaddingH, GameData.windowWidth, GameData.menuRectOptionH);

    MyFrame frame;

    myButton playBtn;
    myButton tournamentBtn;
    myButton statsBtn;
    myButton userBtn;
    myButton exitBtn;

    JPanel menuPanel;
    JPanel titlePanel;

    JLabel titleLabel;
    JLabel userLabel;

    public Menu(Graphics g, MyFrame frame){
        this.frame = frame;

        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBounds(new Rectangle(0,0,GameData.windowWidth, GameData.menuRectTitleH + GameData.menuRectSubtitleH + GameData.menuPaddingH));
        titlePanel.setBackground(Color.BLACK);

        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(menuRectOptions);
        menuPanel.setBackground(Color.BLACK);

        drawMenu(g);
        setButtons();

        frame.add(titlePanel);
        frame.add(menuPanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();


    }

    private void setButtons(){
        playBtn = new myButton(new Rectangle(GameData.windowWidth * 3/8, 0, GameData.windowWidth / 4, GameData.menuRectOptionH / 5),"play", menuPanel);
        tournamentBtn = new myButton(new Rectangle(GameData.windowWidth * 3/8,  GameData.menuRectOptionH / 5, GameData.windowWidth / 4, GameData.menuRectOptionH / 5),"tournament", menuPanel);
        statsBtn = new myButton(new Rectangle(GameData.windowWidth * 3/8,  2 * GameData.menuRectOptionH / 5, GameData.windowWidth / 4, GameData.menuRectOptionH / 5),"stats", menuPanel);
        userBtn = new myButton(new Rectangle(GameData.windowWidth * 3/8, 3 * GameData.menuRectOptionH / 5, GameData.windowWidth / 4, GameData.menuRectOptionH / 5),"user", menuPanel);
        exitBtn = new myButton(new Rectangle(GameData.windowWidth * 3/8,  4 * GameData.menuRectOptionH / 5, GameData.windowWidth / 4, GameData.menuRectOptionH / 5),"exit", menuPanel);

//        playBtn = new myButton(new Rectangle(GameData.windowWidth * 3/8, GameData.menuRectTitleH + GameData.menuRectSubtitleH + GameData.menuPaddingH, GameData.windowWidth / 4, GameData.menuRectOptionH / 5),"play", menuPanel);
        exitBtn.addActionListener(e -> System.exit(0));


    }

    public void drawMenu(Graphics g){
        titleLabel = new JLabel("PONG GAME", SwingConstants.CENTER);
        titleLabel.setBounds(new Rectangle(0, GameData.menuPaddingH, GameData.windowWidth, GameData.menuRectTitleH));
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(Window.fontTitle);
        titleLabel.setVisible(true);

        userLabel = new JLabel("Hello Guest!", SwingConstants.CENTER);
        userLabel.setBounds(new Rectangle(0, GameData.menuPaddingH + GameData.menuRectTitleH, GameData.windowWidth, GameData.menuRectSubtitleH));
        userLabel.setBackground(Color.BLACK);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(Window.fontSecond);
        userLabel.setVisible(true);

        titlePanel.add(titleLabel);
        titlePanel.add(userLabel);

//        GameData.drawCenteredString(g, title, menuRectTitle, Window.fontTitle);
//        GameData.drawCenteredString(g, logged, menuRectSubtitle, Window.fontSubtitle);
//        GameData.drawCenteredArrStrings(g, options, menuRectOptions, Window.fontSecond, currOption);
//        buttons();
    }

    public void buttons(){
        JButton button = new JButton("abcd");
        button.setBounds(menuRectTitle);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFont(Window.fontOption);
        frame.add(button);
    }

    public static void changeLogged(String user){
        logged = "Hello " + user + "!";
        System.out.println(logged);
    }
}
