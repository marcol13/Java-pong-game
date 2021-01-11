import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


public class Window extends JFrame implements Runnable{

    Game game;
    Clock clock;
    Graphics2D g;
    KListener kl = new KListener();
    Users user = new Users();
    Menu menu = new Menu();

    public static Font fontTitle;
    public static Font fontSubtitle;
    public static Font fontOption;


    public Window(){
        //Dodać fullscreen
        this.setSize(GameData.windowWidth,GameData.windowHeight);
        this.setTitle(GameData.title);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(kl);

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

        g = (Graphics2D)this.getGraphics();
        menu.changeLogged(user.getCurrUser());

        game = new Game(g, kl, "2v2AI");
        clock = new Clock();
    }


    public void draw(Graphics g, double dt){
        Graphics2D g2 = (Graphics2D)g;

        g.setColor(Color.BLACK);
        g.fillRect(0,0,GameData.windowWidth, GameData.windowHeight);

        game.updateGame(g2,dt,clock);
    }


    public void update(double dt){
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg,dt);

        if(!game.startGame) {
            if (kl.getKeyPressed(KeyEvent.VK_ENTER) || kl.getKeyPressed(KeyEvent.VK_SPACE)) {
                game.startGame = true;
                Game.pausedGame = false;
                clock.start();

            }
        }
        if(Game.pausedGame){
            if (kl.getKeyPressed(KeyEvent.VK_ENTER) || kl.getKeyPressed(KeyEvent.VK_SPACE)) {
                Game.pausedGame = false;
            }
        }
        g.drawImage(dbImage, 0, 0, this);



        /*g.setColor(Color.BLACK);
        g.fillRect(0,0,GameData.windowWidth, GameData.windowHeight);
        g.setColor(Color.WHITE);
        menu.drawMenu(g);

        if(kl.getKeyPressed(KeyEvent.VK_UP)){
            if(menu.currOption > 0)
                menu.currOption--;
        }
        if(kl.getKeyPressed(KeyEvent.VK_DOWN)){
            if(menu.currOption < menu.options.length - 1)
                menu.currOption++;
        }
        if(kl.getKeyPressed(KeyEvent.VK_ENTER) || kl.getKeyPressed(KeyEvent.VK_SPACE)){
            if(menu.currOption == 0){

            }
            if(menu.currOption == 5)
                System.exit(0);
        }*/
    }

    public void run(){
        double lastFrame = 0.0;
        while(true){
            double time = Time.getTime();
            double deltaTime = time - lastFrame;
            lastFrame = time;

            update(deltaTime);

            try{
                Thread.sleep(30);
            }catch(Exception e){
            }
        }
    }
}
