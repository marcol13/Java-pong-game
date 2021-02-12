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

    JLabel player1IconLabel;
    JLabel player2IconLabel;
    JLabel cpu1IconLabel;
    JLabel cpu2IconLabel;

    String[] options = {"1 VS AI", "1 VS 1", "2 VS 2AI"};

    int mode;

    public PlaySettings(MyFrame frame, int mode){
        this.frame = frame;
        this.mode = mode;

        playPanel = new JPanel();
        playPanel.setLayout(null);
        playPanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        playPanel.setBackground(Color.BLACK);
        playPanel.setVisible(true);

        updatePlaySettings();
    }

    public void updatePlaySettings(){
        setPlayPanel();
        frame.add(playPanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void setPlayPanel(){
        player1Icon = new ImageIcon("bin/player-walk-right.gif");

        modeTitleLabel = new JLabel("", SwingConstants.CENTER);
        modeTitleLabel.setBounds(new Rectangle(0, GameData.loginPaddingH - 2 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        modeTitleLabel.setBackground(Color.BLACK);
        modeTitleLabel.setForeground(Color.WHITE);
        modeTitleLabel.setFont(Window.fontSecond);
        modeTitleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        modeTitleLabel.setVisible(true);


        switch (mode) {
            case 0 -> {
                modeTitleLabel.setText("Player VS CPU");

                player1IconLabel = new JLabel(player1Icon);
                player1IconLabel.setBounds(new Rectangle(GameData.windowWidth / 10, GameData.windowHeight / 2 - 3 * GameData.loginRectH, player1Icon.getIconWidth(), player1Icon.getIconHeight()));
                player1IconLabel.setVisible(true);

                cpu1Icon = new ImageIcon("bin/robot-idle-left.gif");

                cpu1IconLabel = new JLabel(cpu1Icon);
                cpu1IconLabel.setBounds(new Rectangle(GameData.windowWidth * 9 / 10 - cpu1Icon.getIconWidth(), GameData.windowHeight / 2 - 3 * GameData.loginRectH, cpu1Icon.getIconWidth(), cpu1Icon.getIconHeight()));
                cpu1IconLabel.setVisible(true);

                playPanel.add(player1IconLabel);
                playPanel.add(cpu1IconLabel);

                startGameBtn = new myButton(new Rectangle(GameData.windowWidth / 3, GameData.windowHeight - GameData.menuPaddingH - 150 , GameData.windowWidth / 3 , GameData.loginRectH) ,"start game", playPanel);
            }
            case 1 -> {
                modeTitleLabel.setText("Player VS Player");

                player1IconLabel = new JLabel(player1Icon);
                player1IconLabel.setBounds(new Rectangle(GameData.windowWidth / 10, GameData.windowHeight / 2 - 3 * GameData.loginRectH, player1Icon.getIconWidth(), player1Icon.getIconHeight()));
                player1IconLabel.setVisible(true);

                player2Icon = new ImageIcon("bin/player-walk-left.gif");

                player2IconLabel = new JLabel(player2Icon);
                player2IconLabel.setBounds(new Rectangle(GameData.windowWidth * 9 / 10 - player2Icon.getIconWidth(), GameData.windowHeight / 2 - 3 * GameData.loginRectH, player2Icon.getIconWidth(), player2Icon.getIconHeight()));
                player2IconLabel.setVisible(true);

                JTextField player2TextField = new JTextField();
                player2TextField.setBounds(new Rectangle(GameData.loginPaddingW * 3 / 2, GameData.windowHeight / 2 -  GameData.loginRectH, GameData.windowWidth - 3 * GameData.loginPaddingW, GameData.loginRectH));
                player2TextField.setFont(Window.fontSecond);
                player2TextField.setForeground(Color.WHITE);
                player2TextField.setBackground(Color.BLACK);
                player2TextField.setCaretColor(Color.WHITE);

                JLabel player2Label = new JLabel("PLAYER 2 NICKNAME", SwingConstants.CENTER);
                player2Label.setBounds(new Rectangle(GameData.loginPaddingW * 3 / 2, GameData.windowHeight / 2 -  2 * GameData.loginRectH, GameData.windowWidth - 3 * GameData.loginPaddingW, GameData.loginRectH));
                player2Label.setFont(Window.fontSecondSmall);
                player2Label.setForeground(Color.WHITE);
                player2Label.setBackground(Color.BLACK);

                playPanel.add(player1IconLabel);
                playPanel.add(player2IconLabel);
                playPanel.add(player2TextField);
                playPanel.add(player2Label);

                startGameBtn = new myButton(new Rectangle(GameData.windowWidth / 3, GameData.windowHeight - GameData.menuPaddingH - 150 , GameData.windowWidth / 3 , GameData.loginRectH) ," start game ", playPanel);
            }
            case 2 -> {
                modeTitleLabel.setText("2 Players VS 2 CPUs");

                player1IconLabel = new JLabel(player1Icon);
                player1IconLabel.setBounds(new Rectangle(GameData.windowWidth / 10, GameData.windowHeight / 2 - 3 * GameData.loginRectH, player1Icon.getIconWidth(), player1Icon.getIconHeight()));
                player1IconLabel.setVisible(true);

                player2Icon = new ImageIcon("bin/player-walk-right.gif");

                player2IconLabel = new JLabel(player2Icon);
                player2IconLabel.setBounds(new Rectangle(GameData.windowWidth / 20, GameData.windowHeight / 2 - GameData.loginRectH, player2Icon.getIconWidth(), player2Icon.getIconHeight()));
                player2IconLabel.setVisible(true);

                cpu1Icon = new ImageIcon("bin/robot-idle-left.gif");

                cpu1IconLabel = new JLabel(cpu1Icon);
                cpu1IconLabel.setBounds(new Rectangle(GameData.windowWidth * 9 / 10 - cpu1Icon.getIconWidth(), GameData.windowHeight / 2 - 3 * GameData.loginRectH, cpu1Icon.getIconWidth(), cpu1Icon.getIconHeight()));
                cpu1IconLabel.setVisible(true);

                cpu2Icon = new ImageIcon("bin/robot-idle-left.gif");

                cpu2IconLabel = new JLabel(cpu1Icon);
                cpu2IconLabel.setBounds(new Rectangle(GameData.windowWidth * 19 / 20 - cpu2Icon.getIconWidth(), GameData.windowHeight / 2 - GameData.loginRectH, cpu2Icon.getIconWidth(), cpu2Icon.getIconHeight()));
                cpu2IconLabel.setVisible(true);

                JTextField player2TextField = new JTextField();
                player2TextField.setBounds(new Rectangle(GameData.loginPaddingW * 3 / 2, GameData.windowHeight / 2 -  GameData.loginRectH, GameData.windowWidth - 3 * GameData.loginPaddingW, GameData.loginRectH));
                player2TextField.setFont(Window.fontSecond);
                player2TextField.setForeground(Color.WHITE);
                player2TextField.setBackground(Color.BLACK);
                player2TextField.setCaretColor(Color.WHITE);

                JLabel player2Label = new JLabel("PLAYER 2 NICKNAME", SwingConstants.CENTER);
                player2Label.setBounds(new Rectangle(GameData.loginPaddingW * 3 / 2, GameData.windowHeight / 2 -  2 * GameData.loginRectH, GameData.windowWidth - 3 * GameData.loginPaddingW, GameData.loginRectH));
                player2Label.setFont(Window.fontSecondSmall);
                player2Label.setForeground(Color.WHITE);
                player2Label.setBackground(Color.BLACK);

                playPanel.add(player2IconLabel);
                playPanel.add(player1IconLabel);
                playPanel.add(cpu2IconLabel);
                playPanel.add(cpu1IconLabel);
                playPanel.add(player2TextField);
                playPanel.add(player2Label);

                startGameBtn = new myButton(new Rectangle(GameData.windowWidth / 3, GameData.windowHeight - GameData.menuPaddingH - 150 , GameData.windowWidth / 3 , GameData.loginRectH) ,"  start game  ", playPanel);
            }
        }


//        JLabel gifLabel = new JLabel(player1Icon);
//        gifLabel.setSize(400,400);



        maxPointsLabel = new JLabel("POINTS TO WIN", SwingConstants.CENTER);
        maxPointsLabel.setBounds(new Rectangle(0 , GameData.windowHeight - 5 * GameData.loginRectH - 7 * GameData.loginPaddingRectH, GameData.windowWidth, GameData.loginRectH));
        maxPointsLabel.setBackground(Color.BLACK);
        maxPointsLabel.setForeground(Color.WHITE);
        maxPointsLabel.setFont(Window.fontSecondSmall);
        maxPointsLabel.setVisible(true);

        maxScoreField = new JTextField();
        maxScoreField.setBounds(new Rectangle(GameData.windowWidth * 14 / 30 , GameData.windowHeight - 4 * GameData.loginRectH - 7 * GameData.loginPaddingRectH, GameData.windowWidth / 15, GameData.loginRectH));
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

//        playPanel.add(gifLabel);
        playPanel.add(modeTitleLabel);
        playPanel.add(maxPointsLabel);
        playPanel.add(maxScoreField);

        if(mode < 2)
            rightArrow = new myButton(new Rectangle(GameData.windowWidth - GameData.menuPaddingW - 200, GameData.windowHeight - GameData.menuPaddingH - 150, 200, 100), "--> ", playPanel);
        if(mode > 0)
            leftArrow = new myButton(new Rectangle(GameData.menuPaddingW, GameData.windowHeight - GameData.menuPaddingH - 150, 200, 100), "<-- ", playPanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", playPanel);

    }
}
