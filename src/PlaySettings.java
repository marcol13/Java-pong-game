import javax.swing.*;
import java.awt.*;

public class PlaySettings {

    MyFrame frame;

    JPanel playPanel;

    JButton backBtn;
    JButton startGameBtn;
    JButton rightArrow;
    JButton leftArrow;

    JLabel modeTitleLabel;
    JLabel maxPointsLabel;
    JLabel gameModeLabel;

    JTextField maxScoreField;

    Icon player1Icon;
    Icon player2Icon;
    Icon cpu1Icon;
    Icon cpu2Icon;

    String[] options = {"1 VS AI", "1 VS 1", "2 VS 2AI"};

    public PlaySettings(MyFrame frame, int mode){
        this.frame = frame;

        playPanel = new JPanel();
        playPanel.setLayout(null);
        playPanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        playPanel.setBackground(Color.BLACK);
        playPanel.setVisible(true);

        setPlayPanel();
        frame.add(playPanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void setPlayPanel(){
        player1Icon = new ImageIcon("bin/player_walk.gif");

        JLabel gifLabel = new JLabel(player1Icon);
        gifLabel.setSize(400,400);


        modeTitleLabel = new JLabel("Player VS CPU", SwingConstants.CENTER);
        modeTitleLabel.setBounds(new Rectangle(0, GameData.loginPaddingH - 2 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        modeTitleLabel.setBackground(Color.BLACK);
        modeTitleLabel.setForeground(Color.WHITE);
        modeTitleLabel.setFont(Window.fontSecond);
        modeTitleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        modeTitleLabel.setVisible(true);

        maxPointsLabel = new JLabel("POINTS TO WIN", SwingConstants.CENTER);
        maxPointsLabel.setBounds(new Rectangle(0 , GameData.windowHeight - 5 * GameData.loginRectH - 2 * GameData.loginPaddingRectH, GameData.windowWidth, GameData.loginRectH));
        maxPointsLabel.setBackground(Color.BLACK);
        maxPointsLabel.setForeground(Color.WHITE);
        maxPointsLabel.setFont(Window.fontSecondSmall);
        maxPointsLabel.setVisible(true);

        maxScoreField = new JTextField();
        maxScoreField.setBounds(new Rectangle(GameData.windowWidth * 9 / 20 , GameData.windowHeight - 4 * GameData.loginRectH - 2 * GameData.loginPaddingRectH, GameData.windowWidth / 10, GameData.loginRectH));
        maxScoreField.setFont(Window.fontSecond);
        maxScoreField.setHorizontalAlignment(JTextField.CENTER);
        maxScoreField.setForeground(Color.WHITE);
        maxScoreField.setBackground(Color.BLACK);
        maxScoreField.setCaretColor(Color.WHITE);
//
//        scoreLabel = new JLabel("WIN-LOSE", SwingConstants.CENTER);
//        scoreLabel.setBounds(new Rectangle(GameData.windowWidth * 2 / 3, GameData.loginPaddingH - 2 * GameData.loginRectH, GameData.windowWidth / 3 , GameData.loginRectH));
//        scoreLabel.setBackground(Color.BLACK);
//        scoreLabel.setForeground(Color.WHITE);
//        scoreLabel.setFont(Window.fontSecond);
//        scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
//        scoreLabel.setVisible(true);
//
//        statsPanel.add(nickLabel);
//        statsPanel.add(scoreLabel);

        playPanel.add(gifLabel);
        playPanel.add(modeTitleLabel);
        playPanel.add(maxPointsLabel);
        playPanel.add(maxScoreField);

        rightArrow = new myButton(new Rectangle(GameData.windowWidth - GameData.menuPaddingW - 200, GameData.windowHeight - GameData.menuPaddingH - 150, 200, 100), "--> ", playPanel);
        leftArrow = new myButton(new Rectangle(GameData.menuPaddingW, GameData.windowHeight - GameData.menuPaddingH - 150, 200, 100), "<-- ", playPanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", playPanel);
        startGameBtn = new myButton(new Rectangle(GameData.windowWidth * 3 / 8, GameData.windowHeight - 3 * GameData.loginRectH - GameData.loginPaddingRectH , GameData.windowWidth / 4 , GameData.loginRectH) ,"start game", playPanel);
    }
}
