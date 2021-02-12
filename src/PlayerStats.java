import javax.swing.*;
import java.awt.*;

public class PlayerStats {

    MyFrame frame;

    JPanel statsPanel;

    JButton backBtn;
    JButton rightArrow;
    JButton leftArrow;

    JLabel nickLabel;
    JLabel scoreLabel;
    JLabel [] labels;

    JScrollPane scroll;

    int page;

    public PlayerStats(MyFrame frame, int page){
        this.frame = frame;
        this.page = page;

        statsPanel = new JPanel();
        statsPanel.setLayout(null);
        statsPanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        statsPanel.setBackground(Color.BLACK);
        statsPanel.setVisible(true);

        updateStats();
    }

    public void updateStats(){
        setStatsPanel();
        setPlayers(page);
        frame.add(statsPanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void setStatsPanel(){
        nickLabel = new JLabel("NICKNAME", SwingConstants.CENTER);
        nickLabel.setBounds(new Rectangle(0, GameData.loginPaddingH - 2 * GameData.loginRectH, GameData.windowWidth * 2 / 3 , GameData.loginRectH));
        nickLabel.setBackground(Color.BLACK);
        nickLabel.setForeground(Color.WHITE);
        nickLabel.setFont(Window.fontSecond);
        nickLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        nickLabel.setVisible(true);

        scoreLabel = new JLabel("WIN-LOSE", SwingConstants.CENTER);
        scoreLabel.setBounds(new Rectangle(GameData.windowWidth * 2 / 3, GameData.loginPaddingH - 2 * GameData.loginRectH, GameData.windowWidth / 3 , GameData.loginRectH));
        scoreLabel.setBackground(Color.BLACK);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(Window.fontSecond);
        scoreLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        scoreLabel.setVisible(true);

        statsPanel.add(nickLabel);
        statsPanel.add(scoreLabel);

        if(Window.players > (page + 1) * 9)
            rightArrow = new myButton(new Rectangle(GameData.windowWidth - GameData.menuPaddingW - 200, GameData.windowHeight - GameData.menuPaddingH - 150, 200, 100), "-->", statsPanel);
        if(page > 0)
            leftArrow = new myButton(new Rectangle(GameData.menuPaddingW, GameData.windowHeight - GameData.menuPaddingH - 150, 200, 100), "<--", statsPanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", statsPanel);
    }

    public void setPlayers(int n){
        labels = new JLabel [Window.players * 2];
        for(int i = n * 9, j = n * 9 * 3; i < Window.players && i < (n + 1) * 9; i++,  j += 3){
            labels[i*2] = new JLabel(Window.userInfo[j], SwingConstants.CENTER);
            labels[i*2].setBounds(new Rectangle(0, GameData.loginPaddingH -  GameData.loginRectH + GameData.loginPaddingRectH + (i % 9) * GameData.loginRectH, GameData.windowWidth * 2 / 3, GameData.loginRectH));
            labels[i*2].setBackground(Color.BLACK);
            labels[i*2].setForeground(Color.WHITE);
            labels[i*2].setFont(Window.fontSecond);
            labels[i*2].setVisible(true);

            labels[i*2+1] = new JLabel(Window.userInfo[j+1] + " - " + Window.userInfo[j+2], SwingConstants.CENTER);
            labels[i*2+1].setBounds(new Rectangle(GameData.windowWidth * 2 / 3, GameData.loginPaddingH -  GameData.loginRectH + GameData.loginPaddingRectH + (i % 9) * GameData.loginRectH, GameData.windowWidth / 3, GameData.loginRectH));
            labels[i*2+1].setBackground(Color.BLACK);
            labels[i*2+1].setForeground(Color.WHITE);
            labels[i*2+1].setFont(Window.fontSecond);
            labels[i*2+1].setVisible(true);

            statsPanel.add(labels[i*2]);
            statsPanel.add(labels[i*2+1]);
        }
    }
}
