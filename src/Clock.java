import java.util.Timer;
import java.util.TimerTask;

public class Clock implements Runnable{
    int elapsedTime;
    int seconds;
    int minutes;

    boolean started;
    public boolean paused;

    Timer timer = new Timer();
    TimerTask task = new TimerTask(){
        public void run(){
            if(!paused) {
                elapsedTime++;
                seconds = elapsedTime % 60;
                minutes = (int) (elapsedTime / 60) % 60;
            }
        }
    };
    
    public Clock(){
        this.elapsedTime = 0;
        this.seconds = 0;
        this.minutes = 0;
        this.started = false;
        this.paused = false;
    }

    public void run(){
        timer.scheduleAtFixedRate(task,1000,1000);
    }

    public String getTimeString(){
        String minutesString = String.format("%02d", minutes);
        String secondsString = String.format("%02d", seconds);
        return minutesString + "-" + secondsString;
    }


}
