import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Window extends JFrame implements Runnable{

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
    }



    public void update(double dt){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,GameData.windowWidth, GameData.windowHeight);

        g.setColor(Color.RED);
        menu.drawMenu(g);

        if(kl.getKeyPressed(KeyEvent.VK_UP)){
            System.out.println("Strzałka w górę!");
        }
        if(kl.getKeyPressed(KeyEvent.VK_DOWN)){
            System.out.println("Strzałka w dół!");
        }
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
