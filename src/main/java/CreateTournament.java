import javax.swing.*;
import java.awt.*;

public class CreateTournament {
    MyFrame frame;

    myButton backBtn;
    myButton createBtn;

    JPanel tournamentCreatePanel;

    JLabel nameLabel;
    JLabel user2Label;
    JLabel user3Label;
    JLabel user4Label;

    JTextField nameTextField;
    JTextField user2TextField;
    JTextField user3TextField;
    JTextField user4TextField;

    public CreateTournament(MyFrame frame){
        this.frame = frame;

        tournamentCreatePanel = new JPanel();
        tournamentCreatePanel.setLayout(null);
        tournamentCreatePanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        tournamentCreatePanel.setBackground(Color.BLACK);
        tournamentCreatePanel.setVisible(true);

        setButtons();
        frame.add(tournamentCreatePanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void setButtons(){
//        gobletIcon = new ImageIcon("bin/goblet-icon.png");
//
//        iconLabel = new JLabel(gobletIcon);
//        iconLabel.setBounds((GameData.windowWidth - gobletIcon.getIconWidth()) / 2, GameData.loginPaddingH / 2, gobletIcon.getIconWidth(), gobletIcon.getIconHeight());
//        iconLabel.setVisible(true);

        nameLabel = new JLabel("TOURNAMENT NAME", SwingConstants.CENTER);
        nameLabel.setBounds(new Rectangle(0, GameData.loginPaddingH - 5 * GameData.loginPaddingRectH - GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        nameLabel.setFont(Window.fontSecondSmall);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBackground(Color.BLACK);

        user2Label = new JLabel("PLAYER 2 NICKNAME", SwingConstants.CENTER);
        user2Label.setBounds(new Rectangle(0, GameData.loginPaddingH - 3 * GameData.loginPaddingRectH + GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        user2Label.setFont(Window.fontSecondSmall);
        user2Label.setForeground(Color.WHITE);
        user2Label.setBackground(Color.BLACK);

        user3Label = new JLabel("PLAYER 3 NICKNAME", SwingConstants.CENTER);
        user3Label.setBounds(new Rectangle(0, GameData.loginPaddingH - GameData.loginPaddingRectH + 3 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        user3Label.setFont(Window.fontSecondSmall);
        user3Label.setForeground(Color.WHITE);
        user3Label.setBackground(Color.BLACK);

        user4Label = new JLabel("PLAYER 4 NICKNAME", SwingConstants.CENTER);
        user4Label.setBounds(new Rectangle(0, GameData.loginPaddingH + GameData.loginPaddingRectH + 5 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        user4Label.setFont(Window.fontSecondSmall);
        user4Label.setForeground(Color.WHITE);
        user4Label.setBackground(Color.BLACK);

        nameTextField = new JTextField();
        nameTextField.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH - 5 * GameData.loginPaddingRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH));
        nameTextField.setFont(Window.fontSecond);
        nameTextField.setForeground(Color.WHITE);
        nameTextField.setBackground(Color.BLACK);
        nameTextField.setCaretColor(Color.WHITE);

        user2TextField = new JTextField();
        user2TextField.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + 2 * GameData.loginRectH - 3 * GameData.loginPaddingRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH));
        user2TextField.setFont(Window.fontSecond);
        user2TextField.setForeground(Color.WHITE);
        user2TextField.setBackground(Color.BLACK);
        user2TextField.setCaretColor(Color.WHITE);

        user3TextField = new JTextField();
        user3TextField.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + 4 * GameData.loginRectH - GameData.loginPaddingRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH));
        user3TextField.setFont(Window.fontSecond);
        user3TextField.setForeground(Color.WHITE);
        user3TextField.setBackground(Color.BLACK);
        user3TextField.setCaretColor(Color.WHITE);

        user4TextField = new JTextField();
        user4TextField.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + 6 * GameData.loginRectH + GameData.loginPaddingRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH));
        user4TextField.setFont(Window.fontSecond);
        user4TextField.setForeground(Color.WHITE);
        user4TextField.setBackground(Color.BLACK);
        user4TextField.setCaretColor(Color.WHITE);

        tournamentCreatePanel.add(nameLabel);
        tournamentCreatePanel.add(user2Label);
        tournamentCreatePanel.add(user3Label);
        tournamentCreatePanel.add(user4Label);

        tournamentCreatePanel.add(nameTextField);
        tournamentCreatePanel.add(user2TextField);
        tournamentCreatePanel.add(user3TextField);
        tournamentCreatePanel.add(user4TextField);

        createBtn = new myButton(new Rectangle(GameData.windowWidth * 3 / 8, GameData.loginPaddingH + 7 * GameData.loginRectH + 3 * GameData.loginPaddingRectH, GameData.windowWidth / 4, GameData.loginRectH), "create", tournamentCreatePanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", tournamentCreatePanel);
    }
}
