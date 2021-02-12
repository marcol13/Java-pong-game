import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlayerInfo {

    public PlayerInfo(){

    }

    public static void getPlayerInfo(String filename){
        int i = 0;
        int j = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(i % 4 != 1){
                    Window.userInfo[j] = data;
                    j++;
                }
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int users_quantity(String filename){
            int i = 0;
            try {
                File myObj = new File(filename);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    i++;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                return -1;
            }
        return i;

    }
}
