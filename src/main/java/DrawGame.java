import java.awt.*;
import java.awt.event.KeyEvent;

public class DrawGame implements Runnable{

    KListener klistener = new KListener();
    MyFrame frame;
    Graphics2D g;

    GameMode1vAI game0;
    GameMode1v1 game1;
    GameMode2v2AI game2;

    public static boolean isGame;
    public static boolean isTournament;
    int gameMode;

    int fps;

    public DrawGame(MyFrame frame, int gameMode, int maxPoints, String playerName1){
        isGame = true;
        this.frame = frame;
        this.fps = 30;
        this.gameMode = gameMode;
        isTournament = false;

        g = (Graphics2D)frame.getGraphics();
        frame.requestFocus();

        switch (gameMode) {
            case 0 -> {
                game0 = new GameMode1vAI(g, MyFrame.kl, maxPoints, playerName1);
            }
        }
    }

    public DrawGame(MyFrame frame, int gameMode, int maxPoints, String playerName1, String playerName2){
        isGame = true;
        this.frame = frame;
        this.fps = 30;
        this.gameMode = gameMode;
        isTournament = false;

        g = (Graphics2D)frame.getGraphics();
        frame.requestFocus();

        switch (gameMode) {
            case 1 -> {
                game1 = new GameMode1v1(g, MyFrame.kl, maxPoints, playerName1, playerName2, false);
            }
            case 2 -> {
                game2 = new GameMode2v2AI(g, MyFrame.kl, maxPoints, playerName1, playerName2);
            }
        }
    }

    public DrawGame(MyFrame frame, int gameMode, int maxPoints, String playerName1, String playerName2, boolean isTournament){
        isGame = true;
        this.frame = frame;
        this.fps = 30;
        this.gameMode = gameMode;
        DrawGame.isTournament = isTournament;

        g = (Graphics2D)frame.getGraphics();
        frame.requestFocus();

        game1 = new GameMode1v1(g, MyFrame.kl, maxPoints, playerName1, playerName2, isTournament);
    }

    public void draw(Graphics g, double dt){
        Graphics2D g2 = (Graphics2D)g;

        g.setColor(Color.BLACK);
        g.fillRect(0,0,frame.getWidth(), frame.getHeight());

        switch (gameMode) {
            case 0 -> {
                game0.updateGame(g2, dt);
            }
            case 1 -> {
                game1.updateGame(g2, dt);
            }
            case 2 -> {
                game2.updateGame(g2, dt);
            }
        }
    }


    public void update(double dt){
        Image dbImage = frame.createImage(frame.getWidth(), frame.getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg,dt);
        g.drawImage(dbImage, 0, 0, frame);
    }

    public void run(){
        double lastFrame = 0.0;
        while(isGame){
            double time = Time.getTime();
            double deltaTime = time - lastFrame;
            lastFrame = time;
            update(deltaTime);
            try{
                Thread.sleep(fps);
            }catch(Exception e){
            }
        }

        if(!isTournament) {
            if (Game.curr_user_wins) {
                for (int i = 0; i < Window.players * 3; i += 3) {
                    if (Window.userInfo[i].equals(Window.curr_user)) {
                        int temp = Integer.parseInt(Window.userInfo[i + 1]);
                        temp += 1;
                        Window.userInfo[i + 1] = Integer.toString(temp);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < Window.players * 3; i += 3) {
                    if (Window.userInfo[i].equals(Window.curr_user)) {
                        int temp = Integer.parseInt(Window.userInfo[i + 2]);
                        temp += 1;
                        Window.userInfo[i + 2] = Integer.toString(temp);
                        break;
                    }
                }
            }
            PlayerInfo.savePlayersInfo(Window.classLoader.getResource("data/users.txt").getPath());
            Window.myFrame.clearFrame();
            Window.menu = new Menu(Window.myFrame);
        }
        else{
            Tournament.players[Tournament.nextPlayer1][Tournament.nextPlayer2] = game1.score[0];
            Tournament.players[Tournament.nextPlayer2][Tournament.nextPlayer1] = game1.score[1];
            Window.myFrame.clearFrame();
            Window.tournament.updateTable();
            Window.tournament.turn++;
        }

    }
}
