import java.io.*;
import java.util.List;

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

    public static void getPlayerInfo(InputStream usersFile){
        int i = 0;
        int j = 0;
        int k = 0;

        List<String> users = new BufferedReader(new InputStreamReader(usersFile)).lines().toList();
        for(String user : users) {
            if (i % 4 != 1){
                Window.userInfo[j] = user;
                j++;
            } else {
                Window.pass[k] = user;
                k++;
            }
            i++;
        }
    }

    public static int users_quantity(InputStream usersFile){
        List<String> users = new BufferedReader(new InputStreamReader(usersFile)).lines().toList();
        return users.size();
    }
}
