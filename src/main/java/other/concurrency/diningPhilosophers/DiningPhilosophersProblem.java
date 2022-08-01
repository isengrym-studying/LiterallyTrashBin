package other.concurrency.diningPhilosophers;

public class DiningPhilosophersProblem {

    public static void main(String[] args) throws Exception {

        final int philosophersQuantity = 5;
        final Philosopher[] philosophers = new Philosopher[philosophersQuantity];
        final Object[] forks = new Object[philosophersQuantity];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1)
                philosophers[i] = new Philosopher(rightFork, leftFork);
            else
                philosophers[i] = new Philosopher(leftFork, rightFork);


            Thread philosopher = new Thread(philosophers[i], "Philosopher " + (i + 1));
            philosopher.start();
        }
    }
}
