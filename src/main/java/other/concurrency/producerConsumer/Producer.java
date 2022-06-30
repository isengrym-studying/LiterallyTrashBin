package other.concurrency.producerConsumer;

import java.util.Random;

public class Producer implements Runnable {
    private final int id;
    private final ConcurrentQueue resource;

    public Producer(int id, ConcurrentQueue resource) {
        this.id = id;
        this.resource = resource;
    }

    @Override
    public void run() {
        Random random = new Random();

        while(true) {
            RandomizedSleep.sleep(700, random, 200);
            produce();
        }
    }


    private void produce() {
        Message message = new Message();

        ifResourceIsFull();
        ifResourceIsNoMoreFull(message);
    }

    private void ifResourceIsFull() {
        if (resource.isFull()) {
            System.out.println("Resource is full. Waiting for some space.");
            resource.waitForSpace();
        }
    }

    private void ifResourceIsNoMoreFull(Message message) {
        resource.add(message);
        System.out.println("Producer " + id + " added the item to the resource. Resource[" + resource.size() + "/" + resource.getMaxSize() + "]");
        resource.notifyAllWaitingOnItems();
    }

}
