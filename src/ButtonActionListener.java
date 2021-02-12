import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String ch = e.getActionCommand();

        if(ch.equals("EXIT")){
            System.exit(0);
        }

        else if(ch.equals("USER")){
            Window.myFrame.clearFrame();
            Window.login = new LoginForm(Window.myFrame);
        }

        else if(ch.equals("BACK")){
            Window.myFrame.clearFrame();
            Window.menu = new Menu(Window.myFrame);
        }

        else if(ch.equals("REGISTER")){
            String nickname = Window.login.loginTextField.getText();
            char[] password = Window.login.passwordField.getPassword();
            if(nickname.length() > 0 && password.length > 0 ){
                new findUser("bin/data/users.txt", nickname);
                if(!Window.login.already_exist) {
                    String[] arr = {nickname, new String(password), "0", "0"};
                    new WriteToFile("bin/data/users.txt", arr);
                    Window.curr_user = nickname;
                    Window.myFrame.clearFrame();
                    Window.menu = new Menu(Window.myFrame);
                }
                else{
                    Window.login.errorLabel.setText("USER ALREADY EXISTS");
                    Window.myFrame.repaint();
                }
            }
            else{
                Window.login.errorLabel.setText("TYPE SOMETHING");
                Window.myFrame.repaint();
            }
        }

        else if(ch.equals("LOGIN")){
            String nickname = Window.login.loginTextField.getText();
            char[] password = Window.login.passwordField.getPassword();
            if(nickname.length() > 0 && password.length > 0 ) {
                new loginToGame("bin/data/users.txt", nickname, new String(password));
                if(Window.login.login_empty){
                    Window.login.errorLabel.setText("THERE IS NO USER WITH THAT LOGIN");
                    Window.myFrame.repaint();
                }
                else if(!Window.login.logged_good){
                    Window.login.errorLabel.setText("WRONG PASSWORD");
                    Window.myFrame.repaint();
                }
                else{
                    Window.myFrame.clearFrame();
                    Window.menu = new Menu(Window.myFrame);
                }
            }
            else{
                Window.login.errorLabel.setText("TYPE SOMETHING");
                Window.myFrame.repaint();
            }
        }

        else if(ch.equals("STATS")){
            Window.statsPage = 0;
            Window.myFrame.clearFrame();
            Window.stats = new PlayerStats(Window.myFrame, Window.statsPage);
        }

        else if(ch.equals("-->")){
            Window.myFrame.clearFrame();
            Window.statsPage++;
            Window.stats = new PlayerStats(Window.myFrame, Window.statsPage);
        }

        else if(ch.equals("<--")){
            Window.myFrame.clearFrame();
            Window.statsPage--;
            Window.stats = new PlayerStats(Window.myFrame, Window.statsPage);
        }

        else if(ch.equals("PLAY")){
            Window.myFrame.clearFrame();
            Window.gameModeInt = 0;
            Window.playSettings = new PlaySettings(Window.myFrame, Window.gameModeInt);
        }

        else if(ch.equals("--> ")){
            Window.myFrame.clearFrame();
            Window.gameModeInt++;
            Window.playSettings = new PlaySettings(Window.myFrame, Window.gameModeInt);
        }

        else if(ch.equals("<-- ")){
            Window.myFrame.clearFrame();
            Window.gameModeInt--;
            Window.playSettings = new PlaySettings(Window.myFrame, Window.gameModeInt);
        }

        else if(ch.equals("START GAME")){
            String maxPoints = Window.playSettings.maxScoreField.getText();
            String nickname;
            boolean readyToGame = false;
            int points = 0;
            if(Window.gameModeInt == 0) {
                if (maxPoints.length() < 1) {
                    Window.playSettings.errorField.setText("TYPE SOMETHING");
                    Window.myFrame.repaint();
                }
                else {
                    try {
                        points = Integer.parseInt(maxPoints);
                        if (points < 1) {
                            Window.playSettings.errorField.setText("INCORRECT DATA");
                            Window.myFrame.repaint();
                        } else {
                            readyToGame = true;
                        }
                    } catch (Exception ex) {
                        Window.playSettings.errorField.setText("NOT A NUMBER");
                        Window.myFrame.repaint();
                    }
                }
                if(readyToGame){
                    Window.myFrame.clearFrame();
                    Thread t1 = new Thread(new DrawGame(Window.myFrame, Window.gameModeInt, points, Window.curr_user));
                    t1.start();
                }
            }
            else{
                nickname = Window.playSettings.player2TextField.getText();
                if (maxPoints.length() < 1 || nickname.length() < 1) {
                    Window.playSettings.errorField.setText("TYPE SOMETHING");
                    Window.myFrame.repaint();
                }
                else {
                    try {
                        points = Integer.parseInt(maxPoints);
                        if (points < 1) {
                            Window.playSettings.errorField.setText("INCORRECT DATA");
                            Window.myFrame.repaint();
                        } else {
                            readyToGame = true;
                        }
                    } catch (Exception ex) {
                        Window.playSettings.errorField.setText("NOT A NUMBER");
                        Window.myFrame.repaint();
                    }
                }
                if(readyToGame){
                    Window.myFrame.clearFrame();
                    Thread t1 = new Thread(new DrawGame(Window.myFrame, Window.gameModeInt, points, Window.curr_user, nickname));
                    t1.start();
                }
            }

        }
    }

}
