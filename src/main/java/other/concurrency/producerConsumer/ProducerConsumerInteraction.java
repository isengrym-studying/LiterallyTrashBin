package other.concurrency.producerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerInteraction {
    public static void main(String[] args) {
        ConcurrentQueue concurrentQueue = new ConcurrentQueue(5);

        int producersQuantity = 1;
        int consumersQuantity = 4;

        ExecutorService executorServiceForProducers = Executors.newFixedThreadPool(producersQuantity);
        ExecutorService executorServiceForConsumers = Executors.newFixedThreadPool(consumersQuantity);

        for (int i = 0; i < producersQuantity; i++) {
            executorServiceForProducers.submit(new Producer(i+1, concurrentQueue));
        }
        for (int i = 0; i < consumersQuantity; i++) {
            executorServiceForConsumers.submit(new Consumer(i+1, concurrentQueue));
        }

        executorServiceForProducers.shutdown();
        executorServiceForConsumers.shutdown();

    }

}
