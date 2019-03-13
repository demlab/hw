
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Spam {
    private long[] time;
    private String[] shoPi3dish;
    private JFrame f;

    Spam(long[] time, String[] s) {
        this.time = time;
        shoPi3dish = s;
        main();
        Part2 p = new Part2();
        p.main();
    }

    public void main(){
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        f.setVisible(true);
        for(int i = 0; i < time.length; i++){
            final int a = i;
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    f.getContentPane().removeAll();
                    JLabel l = new JLabel(shoPi3dish[a]);
                    f.add(l);
                    f.validate();
                }
            };
            Timer t = new Timer();
            t.schedule(tt, time[a]);
        }

    }

}