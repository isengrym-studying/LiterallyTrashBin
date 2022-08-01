package other.concurrency.diningPhilosophers;

public class Philosopher implements Runnable {
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " : " + action);
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction("Thinking");
                synchronized (leftFork) {
                    doAction("Picked up left fork");
                    synchronized (rightFork) {
                        doAction("Picked up right fork - eating");
                        Thread.sleep(2000);
                        doAction("Put down right fork");
                    }

                    doAction("Put down left fork. Back to thinking");
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
