import java.util.Random;

public class Tournament {

    public static boolean last;

    MyFrame frame;

//    public static int [] player1 = new int [4];
//    public static int [] player2 = new int [4];
//    public static int [] player3 = new int [4];
//    public static int [] player4 = new int [4];

    public static int [][] players = new int [4][4];
    public static int nextPlayer1;
    public static int nextPlayer2;

    public String tournamentName;
    public static String [] playerNames;

    public static TournamentTable tournamentTable;

    public static Random rnd = new Random();

    public int turn;

    public Tournament(MyFrame frame, String tournamentName, int turn, String [] playerNames, int [][] playerScores){
        this.frame = frame;
        last = false;
        this.turn = turn;
        this.tournamentName = tournamentName;

        Tournament.playerNames = new String[4];

        System.arraycopy(playerNames, 0, Tournament.playerNames, 0, 4);

        for(int i = 0; i < 4; i++){
            System.arraycopy(playerScores[i], 0, players[i], 0, 4);
        }

        updateTable();

    }

    public void updateTable(){
        tournamentTable = new TournamentTable(frame, tournamentName, turn, Tournament.playerNames, players);
    }

    public String getWinner(){
        int winner = 0;
        int bestScore = 0;
        int currScore;
        for(int i = 0; i < 4; i++){
            currScore = 0;
            for(int j = 0; j < 4; j++){
                if(players[i][j] > -1){
                    if(players[i][j] == 3){
                        currScore += 10;
                    }
                    else {
                        currScore += players[i][j];
                    }
                }
            }
            if(currScore > bestScore){
                bestScore = currScore;
                winner = i;
            }
        }
        return playerNames[winner];
    }

    public static void drawNextPair(){
        boolean flag = false;
        int temp1, temp2;
        while(!flag){
            temp1 = rnd.nextInt(4);
            temp2 = rnd.nextInt(4);
            if(temp1 != temp2 && players[temp1][temp2] == -1){
                nextPlayer1 = temp1;
                nextPlayer2 = temp2;
                flag = true;
            }
        }
    }

}
