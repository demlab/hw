import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Part2 {

    public void main(){
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                try {
                    Robot rb=new Robot();
                    rb.keyPress(KeyEvent.VK_ENTER);
                    rb.keyRelease(KeyEvent.VK_ENTER);
                }catch (AWTException ex) {
                    System.err.println("Robot error");
                }
            }
        };
        Timer t = new Timer();
        t.schedule(tt, 5000);
    }
    public static void main(String[] args){}
}