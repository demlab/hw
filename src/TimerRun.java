public class TimerRun  {

     private  int time = 10;

    public String status() {
        return "(" + (time > 0 ? Thread.currentThread() + ";" + time :"The end!") + ")";
}


    public  void  run() {
        while (time --> 0) {
            System.out.println(status());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args){
        TimerRun timer = new TimerRun();
        timer.run();
    }
}

