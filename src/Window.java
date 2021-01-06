import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Window extends JFrame implements Runnable{

    Game game;
    Graphics2D g;
    KListener kl = new KListener();
    Users user = new Users();
    Menu menu = new Menu();


    public Window(){
        //Dodać fullscreen
        this.setSize(GameData.windowWidth,GameData.windowHeight);
        this.setTitle(GameData.title);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(kl);
        g = (Graphics2D)this.getGraphics();
        menu.changeLogged(user.getCurrUser());

        game = new Game(g, kl);
    }



    public void update(double dt){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,GameData.windowWidth, GameData.windowHeight);

        game.updateGame(g,dt);

        /*g.setColor(Color.WHITE);
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
                Game game = new Game();
                game.drawGame(g);
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
                Thread.sleep(120);
            }catch(Exception e){
            }
        }
    }
}
