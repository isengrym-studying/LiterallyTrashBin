package other.concurrency.producerConsumer;

public class Message {
    public static int counter;
    public int id;

    public Message() {
        counter++;
        this.id = counter;
    }
}
