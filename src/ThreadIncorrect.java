public class ThreadIncorrect {
    private static final int AMOUNT = 100;
    private static final int DELAY = 10;

    public static void main(String[] args) {
        SampleCounter counter = new SampleCounter();

        ThreadGroup group = new ThreadGroup("group");

        Thread one = new Thread(group, new MyThreadCounter(counter, DELAY, AMOUNT), "1");
        Thread two = new Thread(group, new MyThreadCounter(counter, DELAY, AMOUNT), "2");
        Thread three = new Thread(group, new MyThreadCounter(counter, DELAY, AMOUNT), "3");

        one.start();
        two.start();
        three.start();
    }
}

class MyThreadCounter implements Runnable {
    private final SampleCounter counter;
    private final int delayMS;
    private int amount;

    MyThreadCounter(SampleCounter counter, int delayMS, int amount) {
        this.counter = counter;
        this.delayMS = delayMS;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted() && amount != 0) {
                System.out.printf("Thread [%s]: %s;\n", Thread.currentThread().getName(), counter);
                counter.incFirst();
                Thread.sleep(this.delayMS);
                counter.incSecond();
                amount--;
            }
            System.out.printf("Thread [%s] is finish work.\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.printf("Thread [%s] is stopped...\n", Thread.currentThread().getName());
        }
    }
}

class SampleCounter {
    private int firstValue;
    private int secondValue;

    public synchronized void incFirst() {
        this.firstValue++;
    }

    public void incSecond() {
        this.secondValue++;
    }

    @Override
    public String toString() {
        return String.format("%d - %d = %d", this.firstValue, this.secondValue, this.firstValue - this.secondValue);
    }
}