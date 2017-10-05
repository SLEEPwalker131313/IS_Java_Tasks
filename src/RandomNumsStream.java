import java.util.stream.Stream;

class RandomNumsStream {
    static Stream<Long> getStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, it -> (a * it + c) % m);
    }
}
