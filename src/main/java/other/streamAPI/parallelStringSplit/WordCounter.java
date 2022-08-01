package other.streamAPI.parallelStringSplit;

public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
        if(Character.isWhitespace(c))
            return lastSpace ? this : new WordCounter(counter, true);

        return lastSpace ? new WordCounter(counter + 1, false) : this;
    }

    public WordCounter combiner(WordCounter wordCounter) {
        return new WordCounter(this.counter + wordCounter.getCounter(), wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}
