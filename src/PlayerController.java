import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerController {
    public Bar bar;
    public KListener kl;
    public String playerName;
    private int upKey;
    private int downKey;

    public PlayerController(Bar bar, KListener kl, int upKey, int downKey, String playerName){
        this.bar = bar;
        this.kl = kl;
        this.upKey = upKey;
        this.downKey = downKey;
        this.playerName = playerName;
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
