package other.streamAPI.parallelStringSplit;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterMain {
    static final String s =
            "Peter Piper picked a peck of pickled peppers.\n" +
            "A peck of pickled peppers Peter Piper picked.\n" +
            "If Peter Piper picked a peck of pickled peppers,\n" +
            "Where's the peck of pickled peppers Peter Piper picked?";

    public static void main(String[] args) {
        Spliterator<Character> spliterator = new WordCounterSpliterator(s);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        System.out.println(countWords(stream));
    }

    public static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(
                new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combiner);

        return wordCounter.getCounter();
    }
}
