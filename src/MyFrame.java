import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public static KListener kl = new KListener();

    MyFrame() {
        //        this.setSize(GameData.windowWidth,GameData.windowHeight);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
        this.setTitle(GameData.title);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(kl);

        this.getContentPane().setBackground(Color.BLACK);
    }
}
