import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class loginToGame {
    public loginToGame(String filename, String login, String password){
        int i = 0;
        boolean findUser = false;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(findUser) {
                    if(password.equals(data)){
                        Window.curr_user = login;
                        Window.login.logged_good = true;
                    }
                    else{
                        Window.login.logged_good = false;
                    }
                    Window.login.login_empty = false;
                    break;
                }
                if(i % 4 == 0 && data.equals(login)) {
                    findUser = true;
                    System.out.println(data);
                }
                System.out.println(data);
                i++;
            }
            if(!findUser){
                Window.login.login_empty = true;
                Window.login.logged_good = false;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
