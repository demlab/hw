public class ThreadWork {
    public static void main(String[] args) {
        Name one = new Name(5000, 500);
        Thread two = new Thread(new Name(5000, 500), "Thread2");

        two.start();
        one.run();
    }
}

class Name implements Runnable {
    private final int seconds;
    private final int delay;

    public Name(int ms, int delayMs) {
        this.seconds = ms;
        this.delay = delayMs;
    }

    @Override
    public void run() {
        int sum = 0;
        try {
            while (!Thread.currentThread().isInterrupted() && sum <= this.seconds) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(this.delay);
                sum += this.delay;
            }

        } catch (InterruptedException e) {

        }
    }
}
