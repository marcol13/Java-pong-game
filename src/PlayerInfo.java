import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PlayerInfo {

    public PlayerInfo(){

    }

    public static void savePlayersInfo(String filename){
        int k = 0;
        int j = 0;
        try {
            FileWriter myWriter = new FileWriter(filename);
            for(int i = 0; i < Window.players * 4; i++) {
                if(i % 4 == 1){
                    myWriter.write(Window.pass[k] + "\n");
                    k++;
                }
                else {
                    myWriter.write(Window.userInfo[j] + "\n");
                    j++;
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void getPlayerInfo(String filename){
        int i = 0;
        int j = 0;
        int k = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(i % 4 != 1){
                    Window.userInfo[j] = data;
                    j++;
                }
                else{
                    Window.pass[k] = data;
                    k++;
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
