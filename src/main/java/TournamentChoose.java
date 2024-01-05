import javax.swing.*;
import java.awt.*;

public class TournamentChoose {
    Icon gobletIcon;

    MyFrame frame;

    myButton backBtn;
    myButton readTournamentBtn;
    myButton createTournamentBtn;

    JLabel iconLabel;

    JPanel tournamentChoosePanel;

    public TournamentChoose(MyFrame frame){
        this.frame = frame;

        tournamentChoosePanel = new JPanel();
        tournamentChoosePanel.setLayout(null);
        tournamentChoosePanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        tournamentChoosePanel.setBackground(Color.BLACK);
        tournamentChoosePanel.setVisible(true);

        setButtons();
        frame.add(tournamentChoosePanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void setButtons(){
        gobletIcon = new ImageIcon(Window.classLoader.getResource("goblet-icon-2.png").getPath());

        iconLabel = new JLabel(gobletIcon);
        iconLabel.setBounds((GameData.windowWidth - gobletIcon.getIconWidth()) / 2, GameData.loginPaddingH / 2, gobletIcon.getIconWidth(), gobletIcon.getIconHeight());
        iconLabel.setVisible(true);

        tournamentChoosePanel.add(iconLabel);

        readTournamentBtn = new myButton(new Rectangle(GameData.windowWidth / 4, GameData.loginPaddingH + 2 * GameData.loginRectH + 2 * GameData.loginPaddingRectH, GameData.windowWidth / 2 , GameData.loginRectH), "load tournament", tournamentChoosePanel);
        createTournamentBtn = new myButton(new Rectangle(GameData.windowWidth / 4, GameData.loginPaddingH + 4 * GameData.loginRectH + 2 * GameData.loginPaddingRectH, GameData.windowWidth / 2 , GameData.loginRectH),"create tournament", tournamentChoosePanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", tournamentChoosePanel);
    }
}
