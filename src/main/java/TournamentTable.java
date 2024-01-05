import javax.swing.*;
import java.awt.*;

public class TournamentTable {
    MyFrame frame;

    myButton backBtn;
    myButton nextBtn;
    myButton endBtn;
    myButton saveBtn;

    JPanel tournamentTablePanel;

    JLabel nameLabel;
    JLabel nickLabel;
    JLabel winLabel;
    JLabel loseLabel;
    JLabel scoredLabel;

    JLabel [][] userLabel = new JLabel[4][4];

    String tournamentName;

    public String [] playerNames;

    int [][] playerScores = new int[4][4];

    int turn;

    public TournamentTable(MyFrame frame, String tournamentName, int turn, String [] names, int [][] players){
        this.frame = frame;
        this.turn = turn;
        this.tournamentName = tournamentName;

        tournamentTablePanel = new JPanel();
        tournamentTablePanel.setLayout(null);
        tournamentTablePanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        tournamentTablePanel.setBackground(Color.BLACK);
        tournamentTablePanel.setVisible(true);

        this.playerNames = new String[4];

        System.arraycopy(names, 0, this.playerNames, 0, 4);

        for(int i = 0; i < 4; i++){
            System.arraycopy(players[i], 0, playerScores[i], 0, 4);
        }

        setEverything();
        setData();
        frame.add(tournamentTablePanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void setEverything(){
        nameLabel = new JLabel(tournamentName, SwingConstants.CENTER);
        nameLabel.setBounds(new Rectangle(0, GameData.loginPaddingH - 2 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        nameLabel.setBackground(Color.BLACK);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(Window.fontSecond);
        nameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        nameLabel.setVisible(true);

        nickLabel = new JLabel("NICKNAME", SwingConstants.CENTER);
        nickLabel.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH, GameData.windowWidth - 3 * GameData.loginPaddingW, GameData.loginRectH));
        nickLabel.setBackground(Color.BLACK);
        nickLabel.setForeground(Color.WHITE);
        nickLabel.setFont(Window.fontSecond);
        nickLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        nickLabel.setVisible(true);

        winLabel = new JLabel("W", SwingConstants.CENTER);
        winLabel.setBounds(new Rectangle(GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginPaddingH, GameData.loginPaddingW / 3, GameData.loginRectH));
        winLabel.setBackground(Color.BLACK);
        winLabel.setForeground(Color.WHITE);
        winLabel.setFont(Window.fontSecond);
        winLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        winLabel.setVisible(true);

        loseLabel = new JLabel("L", SwingConstants.CENTER);
        loseLabel.setBounds(new Rectangle(GameData.windowWidth - 2 * GameData.loginPaddingW + GameData.loginPaddingW / 3, GameData.loginPaddingH, GameData.loginPaddingW / 3, GameData.loginRectH));
        loseLabel.setBackground(Color.BLACK);
        loseLabel.setForeground(Color.WHITE);
        loseLabel.setFont(Window.fontSecond);
        loseLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        loseLabel.setVisible(true);

        scoredLabel = new JLabel("G", SwingConstants.CENTER);
        scoredLabel.setBounds(new Rectangle(GameData.windowWidth - 2 * GameData.loginPaddingW + GameData.loginPaddingW * 2 / 3, GameData.loginPaddingH, GameData.loginPaddingW / 3, GameData.loginRectH));
        scoredLabel.setBackground(Color.BLACK);
        scoredLabel.setForeground(Color.WHITE);
        scoredLabel.setFont(Window.fontSecond);
        scoredLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        scoredLabel.setVisible(true);

        tournamentTablePanel.add(nameLabel);
        tournamentTablePanel.add(nickLabel);
        tournamentTablePanel.add(winLabel);
        tournamentTablePanel.add(loseLabel);
        tournamentTablePanel.add(scoredLabel);

        if(turn < 5) {
            saveBtn = new myButton(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + 4 * GameData.loginRectH + 10 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW, GameData.loginRectH), "save", tournamentTablePanel);
            nextBtn = new myButton(new Rectangle(GameData.loginPaddingW + (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 + GameData.loginPaddingRectW, GameData.loginPaddingH + 4 * GameData.loginRectH + 10 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW, GameData.loginRectH), "next", tournamentTablePanel);
        }
        else{
            endBtn = new myButton(new Rectangle((GameData.windowWidth - ((GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW)) / 2, GameData.loginPaddingH + 4 * GameData.loginRectH + 10 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW , GameData.loginRectH),"end", tournamentTablePanel);
        }
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", tournamentTablePanel);
    }

    int getWins(int n){
        int result = 0;
        for(int i = 0; i < 4; i++){
            if(playerScores[n][i] == 3){
                result++;
            }
        }
        return result;
    }

    int getLose(int n){
        int result = 0;
        for(int i = 0; i < 4; i++){
            if(playerScores[n][i] > -1 && playerScores[n][i] < 3){
                result++;
            }
        }
        return result;
    }

    int getScoredGoals(int n){
        int result = 0;
        for(int i = 0; i < 4; i++){
            if(playerScores[n][i] > -1){
                result += playerScores[n][i];
            }
        }
        return result;
    }

    int getLostGoals(int n){
        int result = 0;
        for(int i = 0; i < 4; i++){
            if(playerScores[i][n] > -1){
                result += playerScores[i][n];
            }
        }
        return result;
    }

    public void setData(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(j % 4 == 0) {
                    userLabel[i][j] = new JLabel(playerNames[i], SwingConstants.CENTER);
                    userLabel[i][j].setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + (i+1) * GameData.loginRectH, GameData.windowWidth - 3 * GameData.loginPaddingW, GameData.loginRectH));
                    userLabel[i][j].setBackground(Color.BLACK);
                    userLabel[i][j].setForeground(Color.WHITE);
                    userLabel[i][j].setFont(Window.fontSecond);
                    userLabel[i][j].setVisible(true);

                    tournamentTablePanel.add(userLabel[i][j]);
                }
                if(j % 4 == 1){
                    userLabel[i][j] = new JLabel(Integer.toString(getWins(i)), SwingConstants.CENTER);
                    userLabel[i][j].setBounds(new Rectangle(GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginPaddingH + (i+1) * GameData.loginRectH, GameData.loginPaddingW / 3, GameData.loginRectH));
                    userLabel[i][j].setBackground(Color.BLACK);
                    userLabel[i][j].setForeground(Color.WHITE);
                    userLabel[i][j].setFont(Window.fontSecond);
                    userLabel[i][j].setVisible(true);

                    tournamentTablePanel.add(userLabel[i][j]);
                }
                if(j % 4 == 2){
                    userLabel[i][j] = new JLabel(Integer.toString(getLose(i)), SwingConstants.CENTER);
                    userLabel[i][j].setBounds(new Rectangle(GameData.windowWidth - 2 * GameData.loginPaddingW + GameData.loginPaddingW / 3, GameData.loginPaddingH + (i+1) * GameData.loginRectH, GameData.loginPaddingW / 3, GameData.loginRectH));
                    userLabel[i][j].setBackground(Color.BLACK);
                    userLabel[i][j].setForeground(Color.WHITE);
                    userLabel[i][j].setFont(Window.fontSecond);
                    userLabel[i][j].setVisible(true);

                    tournamentTablePanel.add(userLabel[i][j]);
                }
                if(j % 4 == 3){
                    userLabel[i][j] = new JLabel(Integer.toString(getScoredGoals(i)) + "-" + Integer.toString(getLostGoals(i)), SwingConstants.CENTER);
                    userLabel[i][j].setBounds(new Rectangle(GameData.windowWidth - 2 * GameData.loginPaddingW + GameData.loginPaddingW * 2 / 3, GameData.loginPaddingH + (i+1) * GameData.loginRectH, GameData.loginPaddingW / 3, GameData.loginRectH));
                    userLabel[i][j].setBackground(Color.BLACK);
                    userLabel[i][j].setForeground(Color.WHITE);
                    userLabel[i][j].setFont(Window.fontSecond);
                    userLabel[i][j].setVisible(true);

                    tournamentTablePanel.add(userLabel[i][j]);
                }
            }
        }
    }


}
