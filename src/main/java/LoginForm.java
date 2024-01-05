import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginForm{

    boolean logged_good;
    boolean login_empty;
    boolean already_exist;

    OptionRect [] options;

    int currOption;

    String typeLogin;
    String typePassword;

    MyFrame frame;

    myButton loginBtn;
    myButton registerBtn;
    myButton backBtn;

    JPanel loginPanel;

    JTextField loginTextField;

    JPasswordField passwordField;

    JLabel nickLabel;
    JLabel passLabel;
    JLabel errorLabel;

    public LoginForm(MyFrame frame){
        this.frame = frame;
        this.logged_good = false;
        this.login_empty = false;
        this.already_exist = false;

        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(new Rectangle(0, 0, GameData.windowWidth, GameData.windowHeight));
        loginPanel.setBackground(Color.BLACK);
        loginPanel.setVisible(true);

        setLoginForm();
        frame.add(loginPanel);

        frame.invalidate();
        frame.validate();
        frame.repaint();

//        loginRect = new OptionRect(GameData.loginPaddingW, GameData.loginPaddingH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH, Color.WHITE);
//        passwordRect = new OptionRect(GameData.loginPaddingW, GameData.loginPaddingH + GameData.loginRectH + GameData.loginPaddingRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH, Color.WHITE);
//        loginButton = new OptionRect(GameData.loginPaddingW, GameData.loginPaddingH + 2 * GameData.loginRectH + 8 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW , GameData.loginRectH, Color.WHITE);
//        registerButton = new OptionRect(GameData.loginPaddingW + (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 + GameData.loginPaddingRectW, GameData.loginPaddingH + 2 * GameData.loginRectH + 8 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW , GameData.loginRectH, Color.WHITE);
//        currOption = 3;
//        options = new OptionRect[4];
//        options[0] = loginRect;
//        options[1] = passwordRect;
//        options[2] = loginButton;
//        options[3] = registerButton;


    }

    public void setLoginForm(){
        nickLabel = new JLabel("NICKNAME", SwingConstants.CENTER);
        nickLabel.setBounds(new Rectangle(0, GameData.loginPaddingH - GameData.loginRectH - GameData.loginPaddingRectH, GameData.windowWidth , GameData.loginRectH));
        nickLabel.setBackground(Color.BLACK);
        nickLabel.setForeground(Color.WHITE);
        nickLabel.setFont(Window.fontSecond);
        nickLabel.setVisible(true);

        passLabel = new JLabel("PASSWORD", SwingConstants.CENTER);
        passLabel.setBounds(new Rectangle(0, GameData.loginPaddingH + GameData.loginRectH + 2 * GameData.loginPaddingRectH, GameData.windowWidth, GameData.loginRectH));
        passLabel.setBackground(Color.BLACK);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(Window.fontSecond);
        passLabel.setVisible(true);

        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setBounds(new Rectangle(0, GameData.loginPaddingH + GameData.loginRectH + 7 * GameData.loginPaddingRectH + 2 * GameData.loginRectH, GameData.windowWidth, GameData.loginRectH));
        errorLabel.setBackground(Color.BLACK);
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(Window.fontSecondSmall);
        errorLabel.setVisible(true);

        loginTextField = new JTextField();
        loginTextField.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH));
        loginTextField.setFont(Window.fontSecond);
        loginTextField.setForeground(Color.WHITE);
        loginTextField.setBackground(Color.BLACK);
        loginTextField.setCaretColor(Color.WHITE);

        passwordField = new JPasswordField();
        passwordField.setBounds(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + GameData.loginRectH + 3 * GameData.loginPaddingRectH + GameData.loginRectH, GameData.windowWidth - 2 * GameData.loginPaddingW, GameData.loginRectH));
        passwordField.setFont(Window.fontSecond);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(Color.BLACK);
        passwordField.setCaretColor(Color.WHITE);


        loginPanel.add(nickLabel);
        loginPanel.add(passLabel);
        loginPanel.add(errorLabel);
        loginPanel.add(loginTextField);
        loginPanel.add(passwordField);


        loginBtn = new myButton(new Rectangle(GameData.loginPaddingW, GameData.loginPaddingH + 4 * GameData.loginRectH + 10 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW , GameData.loginRectH), "login", loginPanel);
        registerBtn = new myButton(new Rectangle(GameData.loginPaddingW + (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 + GameData.loginPaddingRectW, GameData.loginPaddingH + 4 * GameData.loginRectH + 10 * GameData.loginPaddingRectH, (GameData.windowWidth - 2 * GameData.loginPaddingW) / 2 - GameData.loginPaddingRectW , GameData.loginRectH),"register", loginPanel);
        backBtn = new myButton(new Rectangle(GameData.menuPaddingW, GameData.menuPaddingH, 200 , GameData.loginRectH) ,"back", loginPanel);
    }


//    public void drawLoginForm(Graphics2D g){
//        changeOption();
//        drawLoginRect(g);
//        g.setColor(Color.WHITE);
//        GameData.drawCenteredString(g,"log in", loginButton,Window.fontTitle);
//        GameData.drawCenteredString(g, "register", registerButton, Window.fontTitle);
//        GameData.drawLeftString(g, "type login", loginRect, Window.fontTitle);
//        GameData.drawLeftString(g, "type password", passwordRect, Window.fontTitle);
//        frame.add(label);
//        label.setForeground(Color.WHITE);
//        frame.setVisible(true);
////        panel.setBackground(Color.BLUE);
////        label.setBounds(10,20,80,25);
////
////        panel.setBackground(Color.BLUE);
////        panel.setLayout(null);
////        panel.add(label);
////        frame.add(label);
//    }

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

    }






}
