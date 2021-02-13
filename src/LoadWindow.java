import javax.swing.*;
import java.awt.*;

public class LoadWindow {

    MyFrame frame;

    JPanel loadWindowPanel;

    JTextField pathField;

    myButton backBtn;
    myButton loadBtn;

    JLabel pathLabel;
    JLabel errorLabel;

    public LoadWindow(MyFrame frame){
        this.frame = frame;

        loadWindowPanel = new JPanel();
        loadWindowPanel.setLayout(null);
        loadWindowPanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        loadWindowPanel.setBackground(Color.BLACK);
        loadWindowPanel.setVisible(true);

        setAll();
        frame.add(loadWindowPanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();

    }

    public void setAll(){
        loadBtn = new myButton(new Rectangle(GameData.windowWidth * 3 / 8, GameData.loginPaddingH + 7 * GameData.loginRectH + 3 * GameData.loginPaddingRectH, GameData.windowWidth / 4, GameData.loginRectH) ,"load", loadWindowPanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", loadWindowPanel);
    }
}
