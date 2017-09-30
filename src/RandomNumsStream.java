import java.util.stream.Stream;

public class RandomNumsStream {
    public static Stream<Long> getStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, it -> (a * it + c) % m);
    }
}
