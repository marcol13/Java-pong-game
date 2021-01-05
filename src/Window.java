import javax.swing.JFrame;
import java.awt.*;


public class Window extends JFrame implements Runnable{

    Graphics2D d2;

    public Window(){
        //Dodać fullscreen
        this.setSize(GameData.windowWeight,GameData.windowHeight);
        this.setTitle(GameData.title);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d2 = (Graphics2D)this.getGraphics();
    }

    public void update(double dt){
        d2.setColor(Color.BLACK);
        d2.fillRect(0,0,GameData.windowWeight, GameData.windowHeight);
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
