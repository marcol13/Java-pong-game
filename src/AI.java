public class AI extends Controller{
    Ball ball;

    public AI(Bar bar, String playerName, Ball ball){
        super(bar, playerName);
        this.ball = ball;
    }

    public void update(double dt){
        int diff = ball.getMiddle() - bar.getMiddle();
        if(diff > 0)
            bar.moveBar((int)(-200 * dt));
        else if(diff < 0)
            bar.moveBar((int)(200 * dt));

    }



}
