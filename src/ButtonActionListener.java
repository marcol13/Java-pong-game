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
    }
}
