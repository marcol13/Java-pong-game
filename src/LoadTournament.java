import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadTournament implements Runnable{

    String path;

    public LoadTournament(String path){
        this.path = path;
    }

    public void loadToTournament(){
        String tournamentName;
        int turn;
        String [] playerNames = new String[4];
        int [][] playerScore = new int[4][4];
        try {
            File myObj = new File(Window.jar_path + "bin/data/tournaments/"+path+".txt");
            Scanner myReader = new Scanner(myObj);
            tournamentName = myReader.nextLine();
            turn = Integer.parseInt(myReader.nextLine());
            for(int i = 0; i < 4; i++){
                playerNames[i] = myReader.nextLine();
            }
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    playerScore[i][j] = Integer.parseInt(myReader.nextLine());
                }
            }
            myReader.close();
            Window.myFrame.clearFrame();
            Window.tournament = new Tournament(Window.myFrame, tournamentName, turn, playerNames, playerScore);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void run() {
        loadToTournament();
    }
}
