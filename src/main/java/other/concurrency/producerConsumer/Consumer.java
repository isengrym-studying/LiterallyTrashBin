package other.concurrency.producerConsumer;

import java.util.Random;

public class Consumer implements Runnable {
    private final int id;
    private final ConcurrentQueue resource;

    public Consumer(int id, ConcurrentQueue resource) {
        this.id = id;
        this.resource = resource;
    }

    @Override
    public void run() {
        Random random = new Random();

        while(true) {
            RandomizedSleep.sleep(2000, random, 3000);
            consume();
        }

    }

    private void consume() {
        ifResourceIsEmpty();
        isResourceIsNoMoreEmpty();
    }

    private void ifResourceIsEmpty() {
        if (resource.isEmpty()) {
            System.out.println("Oops, resource is completely empty. Consumer is waiting for items");
            resource.waitForItems();
        }
    }

    private void isResourceIsNoMoreEmpty() {
        Message message = resource.poll();
        String sB = "Consumer " + id + " got the item {" +
                message.id +
                "}. Resource[" + resource.size() + "/" + resource.getMaxSize() + "]";

        System.out.println(sB);
        resource.notifyAllWaitingForSpace();
    }
}
