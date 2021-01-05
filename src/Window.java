import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Window extends JFrame implements Runnable{

    Graphics2D g;
    KListener kl = new KListener();
    Users user = new Users();
    Menu menu = new Menu();
    Font fontTitle = new Font("TimesRoman", Font.PLAIN, (int)(GameData.fontSize * 1.75));
    Font fontSubtitle = new Font("TimesRoman", Font.PLAIN, (int)(GameData.fontSize * 0.75));
    Font fontOption = new Font("TimesRoman", Font.PLAIN, GameData.fontSize);
    Rectangle menuRectTitle = new Rectangle(GameData.menuPaddingW,GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectTitleH);
    Rectangle menuRectSubtitle = new Rectangle(GameData.menuPaddingW,GameData.menuRectTitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectSubtitleH);
    Rectangle menuRectOptions = new Rectangle(GameData.menuPaddingW, GameData.menuRectTitleH + GameData.menuRectSubtitleH + GameData.menuPaddingH, GameData.windowWidth - GameData.menuPaddingW * 2, GameData.menuRectOptionH);

    public Window(){
        //Dodać fullscreen
        this.setSize(GameData.windowWidth,GameData.windowHeight);
        this.setTitle(GameData.title);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(kl);
        g = (Graphics2D)this.getGraphics();

        user.getCurrUser();
        menu.changeLogged(user.getCurrUser());
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public void drawCenteredArrStrings(Graphics g, String[] text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int arrLen = text.length;
        int tileSize = rect.height / arrLen;
        for(int i = 0; i < arrLen; i++) {
            int x = rect.x + (rect.width - metrics.stringWidth(text[i])) / 2;
            int y = rect.y + ((tileSize - metrics.getHeight()) / 2) + metrics.getAscent() + i * tileSize;
            g.setFont(font);
            g.drawString(text[i], x, y);
        }
    }

    public void update(double dt){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,GameData.windowWidth, GameData.windowHeight);

        g.setColor(Color.RED);
        drawCenteredString(g, menu.title, menuRectTitle, fontTitle);
        drawCenteredString(g, menu.logged, menuRectSubtitle, fontSubtitle);
        drawCenteredArrStrings(g, menu.options, menuRectOptions, fontOption);

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
