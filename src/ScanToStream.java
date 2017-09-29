import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ScanToStream <T> {
    public Stream<T> stream;

    private class ScannerToSupplier<T> implements Supplier<T> {

        private Scanner scanner;

        ScannerToSupplier(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public T get() {
            return (T)scanner.next();
        }
    }

    ScanToStream(Scanner scanner){
        ScannerToSupplier<T> supplier = new ScannerToSupplier(scanner);
        this.stream = Stream.generate(supplier);
    }
}
