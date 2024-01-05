import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class findUser {

    public findUser(String filename, String username){
        boolean flag_exist = false;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals(username)){
                    Window.login.already_exist = true;
                    flag_exist = true;
                    break;
                }
            }
            if(!flag_exist){
                Window.login.already_exist = false;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
