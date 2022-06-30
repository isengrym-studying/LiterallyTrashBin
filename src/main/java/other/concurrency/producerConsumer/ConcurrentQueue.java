package other.concurrency.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ConcurrentQueue {
    private final Queue<Message> resource = new LinkedList<>();
    private final int maxSize;
    private final Object full = new Object();
    private final Object empty = new Object();

    public ConcurrentQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public int size() {
        return resource.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isFull() {
        return resource.size() == maxSize;
    }

    public boolean isEmpty() {
        return resource.isEmpty();
    }

    public void waitForItems() {
        synchronized (full) {
            try {
                full.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyAllWaitingOnItems() {
        synchronized (full) {
            full.notifyAll();
        }
    }

    public void waitForSpace() {
        synchronized (empty) {
            try {
                empty.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyAllWaitingForSpace() {
        synchronized (empty) {
            empty.notifyAll();
        }
    }

    public void add(Message message) {
        synchronized (resource) {
            resource.add(message);
        }
    }

    public Message poll() {
        synchronized (resource) {
            return resource.poll();
        }
    }

}
