import java.awt.*;
import java.awt.event.KeyEvent;

public class DrawGame implements Runnable{

    KListener klistener = new KListener();
    MyFrame frame;
    Graphics2D g;

    GameMode1vAI game0;
    GameMode1v1 game1;
    GameMode2v2AI game2;

    public static boolean isGame;
    int gameMode;

    int fps;

    public DrawGame(MyFrame frame, int gameMode, int maxPoints){
        isGame = true;
        this.frame = frame;
        this.fps = 30;
        this.gameMode = gameMode;

        g = (Graphics2D)frame.getGraphics();
        frame.requestFocus();

        switch (gameMode) {
            case 0 -> {
                game0 = new GameMode1vAI(g, MyFrame.kl, maxPoints, Window.curr_user);
            }
            case 1 -> {
                game1 = new GameMode1v1(g, MyFrame.kl, maxPoints);
            }
            case 2 -> {
                game2 = new GameMode2v2AI(g, MyFrame.kl, maxPoints);
            }
        }
    }

    public void draw(Graphics g, double dt){
        Graphics2D g2 = (Graphics2D)g;

        g.setColor(Color.BLACK);
        g.fillRect(0,0,frame.getWidth(), frame.getHeight());

        switch (gameMode) {
            case 0 -> {
                game0.updateGame(g2, dt);
            }
            case 1 -> {
                game1.updateGame(g2, dt);
            }
            case 2 -> {
                game2.updateGame(g2, dt);
            }
        }
    }


    public void update(double dt){
        Image dbImage = frame.createImage(frame.getWidth(), frame.getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg,dt);
        g.drawImage(dbImage, 0, 0, frame);
    }

    public void run(){
        double lastFrame = 0.0;
        while(true){
            if(isGame) {
                double time = Time.getTime();
                double deltaTime = time - lastFrame;
                lastFrame = time;
                update(deltaTime);
            }
            try{
                Thread.sleep(fps);
            }catch(Exception e){
            }
        }
    }
}
