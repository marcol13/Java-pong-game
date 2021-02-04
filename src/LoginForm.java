import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginForm{

    KListener kl;

    OptionRect loginRect;
    OptionRect passwordRect;
    OptionRect loginButton;
    OptionRect registerButton;

    OptionRect [] options;

    int currOption;

    String typeLogin;
    String typePassword;

    MyFrame frame;
    JLabel label;
    JPanel panel;

    public LoginForm(Graphics2D g, KListener kl, MyFrame frame){
        this.kl = kl;
        this.frame = frame;
        loginRect = new OptionRect(GameData.loginPaddingW, GameData.loginPaddingH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH, Color.WHITE);
        passwordRect = new OptionRect(GameData.loginPaddingW, GameData.loginPaddingH + GameData.loginRectH + GameData.loginPaddingRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH, Color.WHITE);
        loginButton = new OptionRect(GameData.loginPaddingW, GameData.loginPaddingH + 2 * GameData.loginRectH + 8 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW , GameData.loginRectH, Color.WHITE);
        registerButton = new OptionRect(GameData.loginPaddingW + (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 + GameData.loginPaddingRectW, GameData.loginPaddingH + 2 * GameData.loginRectH + 8 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW , GameData.loginRectH, Color.WHITE);
        currOption = 3;
        options = new OptionRect[4];
        options[0] = loginRect;
        options[1] = passwordRect;
        options[2] = loginButton;
        options[3] = registerButton;

        label = new JLabel("jakis tekst", JLabel.LEFT);
        label.setBounds(10,10,200,200);
//        panel = new JPanel();

        drawLoginForm(g);
    }



    public void drawLoginForm(Graphics2D g){
        changeOption();
        drawLoginRect(g);
        g.setColor(Color.WHITE);
        GameData.drawCenteredString(g,"log in", loginButton,Window.fontTitle);
        GameData.drawCenteredString(g, "register", registerButton, Window.fontTitle);
        GameData.drawLeftString(g, "type login", loginRect, Window.fontTitle);
        GameData.drawLeftString(g, "type password", passwordRect, Window.fontTitle);
        frame.add(label);
        label.setForeground(Color.WHITE);
        frame.setVisible(true);
//        panel.setBackground(Color.BLUE);
//        label.setBounds(10,20,80,25);
//
//        panel.setBackground(Color.BLUE);
//        panel.setLayout(null);
//        panel.add(label);
//        frame.add(label);
    }

    public void drawLoginRect(Graphics2D g){
        for(int i = 0; i < 4; i++){
            if(i == currOption) {
                options[i].color = Color.RED;
            }
            else{
                options[i].color = Color.WHITE;

            }
            options[i].drawRect(g);
        }

        loginRect.drawRect(g);
        passwordRect.drawRect(g);
        loginButton.drawRect(g);
        registerButton.drawRect(g);
    }

    public void changeOption(){
        if(kl.getKeyPressed(KeyEvent.VK_UP)){
            if(currOption > 0)
                currOption--;
        }
        if(kl.getKeyPressed(KeyEvent.VK_DOWN)){
            if(currOption < options.length - 1)
                currOption++;
        }
        /*if(kl.getKeyPressed(KeyEvent.VK_ENTER) || kl.getKeyPressed(KeyEvent.VK_SPACE)){
            if(menu.currOption == 0){

            }
            if(menu.currOption == 5)
                System.exit(0);
        }*/
    }





}
