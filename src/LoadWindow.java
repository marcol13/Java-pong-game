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
        pathLabel = new JLabel("TOURNAMENT'S NAME TO LOAD", SwingConstants.CENTER);
        pathLabel.setBounds(new Rectangle(0, GameData.loginPaddingH, GameData.windowWidth , GameData.loginRectH));
        pathLabel.setBackground(Color.BLACK);
        pathLabel.setForeground(Color.WHITE);
        pathLabel.setFont(Window.fontSecondSmall);
        pathLabel.setVisible(true);

        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setBounds(new Rectangle(0, GameData.loginPaddingH + 4 * GameData.loginRectH + GameData.loginPaddingRectH, GameData.windowWidth , GameData.loginRectH));
        errorLabel.setBackground(Color.BLACK);
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(Window.fontSecondSmall);
        errorLabel.setVisible(true);

        pathField = new JTextField();
        pathField.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + GameData.loginRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH));
        pathField.setFont(Window.fontSecond);
        pathField.setForeground(Color.WHITE);
        pathField.setBackground(Color.BLACK);
        pathField.setCaretColor(Color.WHITE);

        loadWindowPanel.add(pathLabel);
        loadWindowPanel.add(errorLabel);
        loadWindowPanel.add(pathField);

        loadBtn = new myButton(new Rectangle(GameData.windowWidth * 3 / 8, GameData.loginPaddingH + 7 * GameData.loginRectH + 3 * GameData.loginPaddingRectH, GameData.windowWidth / 4, GameData.loginRectH) ,"load", loadWindowPanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", loadWindowPanel);
    }
}
