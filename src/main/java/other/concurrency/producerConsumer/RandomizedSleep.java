package other.concurrency.producerConsumer;

import java.util.Random;

public class RandomizedSleep {
    public static void sleep (int obligatorySleepTime, Random random, int randomBound) {
        try {
            Thread.sleep(obligatorySleepTime + random.nextInt(randomBound));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
