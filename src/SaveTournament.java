import java.io.FileWriter;
import java.io.IOException;

public class SaveTournament implements Runnable{

    public SaveTournament() {

    }

    private void saveToFile(){
        try {
            FileWriter myWriter = new FileWriter(Window.jar_path + "bin/data/tournaments/"+Window.tournament.tournamentName+".txt");
            myWriter.write(Window.tournament.tournamentName+"\n");
            myWriter.write(Window.tournament.turn +"\n");
            for(int i = 0; i < 4; i++){
                myWriter.write(Tournament.playerNames[i]+"\n");
            }
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    myWriter.write(Tournament.players[i][j]+"\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void run() {
        saveToFile();
    }
}
