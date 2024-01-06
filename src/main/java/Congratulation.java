import javax.swing.*;
import java.awt.*;

public class Congratulation {
    MyFrame frame;

    Icon icon1;
    Icon icon2;

    JPanel gratsPanel;

    JLabel iconLabel1;
    JLabel iconLabel2;
    JLabel gratsLabel;
    JLabel winnerLabel;

    myButton backBtn;
    myButton okBtn;

    String tournamentName;
    String winner;

    public Congratulation(MyFrame frame, String tournamentName, String winner){
        this.frame = frame;
        this.tournamentName = tournamentName;
        this.winner = winner;

        gratsPanel = new JPanel();
        gratsPanel.setLayout(null);
        gratsPanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        gratsPanel.setBackground(Color.BLACK);
        gratsPanel.setVisible(true);

        setAll();
        frame.add(gratsPanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void setAll(){
        icon1 = IconUtils.getIconByName("boiler-right.gif");

        iconLabel1 = new JLabel(icon1);
        iconLabel1.setBounds(new Rectangle(400 - icon1.getIconWidth() / 2, GameData.windowHeight / 2 - 4 * GameData.loginRectH, icon1.getIconWidth(), icon1.getIconHeight()));
        iconLabel1.setVisible(true);

        icon2 = IconUtils.getIconByName("boiler-left.gif");

        iconLabel2 = new JLabel(icon2);
        iconLabel2.setBounds(new Rectangle(GameData.windowWidth - 400 - icon2.getIconWidth() / 2, GameData.windowHeight / 2 - 4 * GameData.loginRectH, icon2.getIconWidth(), icon2.getIconHeight()));
        iconLabel2.setVisible(true);

        gratsLabel = new JLabel("CONGRATULATION!", SwingConstants.CENTER);
        gratsLabel.setBounds(new Rectangle(0 , GameData.windowHeight / 2 - 4 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        gratsLabel.setFont(Window.fontSecond);
        gratsLabel.setHorizontalAlignment(JTextField.CENTER);
        gratsLabel.setForeground(Color.WHITE);
        gratsLabel.setBackground(Color.BLACK);

        winnerLabel = new JLabel(winner+" won", SwingConstants.CENTER);
        winnerLabel.setBounds(new Rectangle(0 , GameData.windowHeight / 2 - 2 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        winnerLabel.setFont(Window.fontSecond);
        winnerLabel.setHorizontalAlignment(JTextField.CENTER);
        winnerLabel.setForeground(Color.WHITE);
        winnerLabel.setBackground(Color.BLACK);

        gratsPanel.add(iconLabel1);
        gratsPanel.add(iconLabel2);
        gratsPanel.add(gratsLabel);
        gratsPanel.add(winnerLabel);

        okBtn = new myButton(new Rectangle(GameData.windowWidth * 3 / 8, GameData.loginPaddingH + 7 * GameData.loginRectH + 3 * GameData.loginPaddingRectH, GameData.windowWidth / 4, GameData.loginRectH) ,"ok", gratsPanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", gratsPanel);
    }
}
