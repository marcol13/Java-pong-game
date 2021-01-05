import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Window extends JFrame implements Runnable{

    Graphics2D g;
    KListener kl = new KListener();
    Users user = new Users();
    Menu menu = new Menu();
    Font font = new Font("TimesRoman", Font.PLAIN, GameData.fontSize);
    Rectangle menuRectTitle = new Rectangle(GameData.windowWeight, GameData.menuRectTitleH);
    Rectangle menuRectOptions = new Rectangle(0, GameData.menuRectTitleH, GameData.windowWeight, GameData.menuRectOptionH);

    public Window(){
        //Dodać fullscreen
        this.setSize(GameData.windowWeight,GameData.windowHeight);
        this.setTitle(GameData.title);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(kl);
        g = (Graphics2D)this.getGraphics();

        user.getCurrUser();
        menu.changeLogged(user.getCurrUser());
    }

    public void drawCenteredStrings(Graphics g, String[] text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int stringLen = text.length;
        int tileSize = rect.height / stringLen;
        for(int i = 0; i < stringLen; i++) {
            int x = rect.x + (rect.width - metrics.stringWidth(text[i])) / 2;
            int y = rect.y + ((tileSize - metrics.getHeight()) / 2) + metrics.getAscent() + (i+1) * tileSize;
            g.setFont(font);
            g.drawString(text[i], x, y);
        }
    }

    public void update(double dt){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,GameData.windowWeight, GameData.windowHeight);

        g.setColor(Color.RED);
        drawCenteredStrings(g, menu.titleString, menuRectTitle, font);
        drawCenteredStrings(g, menu.options, menuRectOptions, font);

        if(kl.getKeyPressed(KeyEvent.VK_UP)){
            System.out.println("Strzałka w górę!");
        }
        if(kl.getKeyPressed(KeyEvent.VK_DOWN)){
            System.out.println("Strzałka w dół!");
        }
    }

    public void run(){
        double lastFrame = 0.0;
        update(0.0);
        /*while(true){
            double time = Time.getTime();
            double deltaTime = time - lastFrame;
            lastFrame = time;

            update(deltaTime);

            try{
                Thread.sleep(30);
            }catch(Exception e){
            }
        }*/
    }
}
