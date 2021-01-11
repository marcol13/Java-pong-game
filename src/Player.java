public class Player extends Controller{
    public KListener kl;
    private int upKey;
    private int downKey;

    public Player(Bar bar, String playerName, KListener kl, int upKey, int downKey){
        super(bar, playerName);
        this.kl = kl;
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public void update(double dt){
        if(kl.getKeyPressed(downKey)){
            bar.moveBar((int)-(100 * dt));
        }
        if(kl.getKeyPressed(upKey)){
            bar.moveBar((int)(100 * dt));
        }
    }
}
