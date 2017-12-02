import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void Task1() {
        /*
        Euclid’s algorithm (which is over two thousand years old) computes the
        greatest common divisor of two numbers as gcd(a, b) = a if b is zero,
        and gcd(b, rem(a, b)) otherwise, where rem is the remainder. Clearly,
        the gcd should not be negative, even if a or b are (since its negation
        would then be a greater divisor). Implement the algorithm with %, floorMod,
        and a rem function that produces the mathematical (non-negative) remainder.
        Which of the three gives you the least hassle with negative values?
         */
        int a = 8;
        int b = 4;
        System.out.println(GCD.gcd_perc(a, b));
        System.out.println(GCD.gcd_floorMod(a, b));
        System.out.println(GCD.gcd_rem(a, b));
    }

    private static void Task2(String str) {
        /*
        Implement a bidirectional Rot13 algorithm. Encode/decode
        a string from the command line argument.
         */
        StringBuilder newStr = new StringBuilder(str);
        System.out.println("original str = " + newStr);
        System.out.println("Encode...");
        newStr = Rot13.encode(newStr.toString());
        System.out.println("new str = " + newStr);
        System.out.println("Decode...");
        newStr = Rot13.decode(newStr.toString());
        System.out.println("new str = " + newStr);
    }

    private static void Task3() {
        /*
        Write a program to convert an input hexadecimal
        string into its equivalent decimal number.
         */
        String hexNum = "78AB";
        System.out.println(HexToDec.convert(hexNum));
        System.out.println("Standard Implementation: ");
        System.out.println(Long.decode("0x" + hexNum));

    }

    public static void Task4(){
        /*
        Write methods that turn a Scanner into a stream
        of words, lines, integers, or double values.
         */
        Scanner scanner = new Scanner("12 546 1427 8421");
        ScanToStream stream = new ScanToStream(scanner);
    }

    private static void Task5() throws IOException {
        /*
        Unzip the src.zip file from the JDK. Using Files.walk, find
        all Java files that contain the keywords transient and volatile.
         */
        String path = "//home/vadim//Загрузки//jdk1.8.0_144//src.zip";
        String outpath = "//home/vadim//Загрузки//jdksrc";

        KeywordSearcher.unZipIt(path, outpath);
        KeywordSearcher.findFiles(outpath);

    }

    private static void Task6(char symbol) throws IOException {
        /*
        Write an example that counts the number of times a particular character,
        such as E, appears in a file. The character can be specified at the command line
         */
        System.out.println(CharCounter.count("//home//vadim//Загрузки//slurm-62472.out", symbol));
    }

    private static void Task7(String arg) {
        /*
        Write a program that reads a text file, specified by the first command line
        argument, into a List. The program should then print random lines from the
        file, the number of lines printed to be specified by the second command
        line argument. Write the program so that a correctly-sized collection is
        allocated all at once, instead of being gradually expanded as the file is
        read in. Hint: To determine the number of lines in the file, use
        java.io.File.length to obtain the size of the file, then divide by an
        assumed size of an average line
         */
        try {
            List<String> list = FileToList.getList(arg, 5);
            System.out.println("list = " + list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Task8(){
        /*
        Using Stream.iterate, make an infinite stream of random numbers—not by
        calling Math.random but by directly implementing a linear congruential
        generator. In such a generator, you start with x0 = seed and then
        produce xn + 1 = (a xn + c) % m, for appropriate values of a, c, and m.
        You should implement a method with parameters a, c, m, and seed that yields
        a Stream. Try out a = 25214903917, c = 11, and m = 2^48.
         */
        //Be careful. An infinite stream!!!
        Stream<Long> stream = RandomNumsStream.getStream(1, 25214903917L, 11, 2^48);
        stream.forEach(System.out::println);
    }

    private static void Task9(Stream<Integer> firstStream, Stream<Integer> secondStream) {
        /*
        Write a method public static Stream zip(Stream first, Stream second) that alternates
        elements from the streams first and second, stopping when one of them runs out of elements.
         */
        StreamZip.zip(firstStream, secondStream)
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        //Task1();
        //if (args.length != 0) Task2(args[0]);
        //Task3();
        //Task4();
        //Task5();
        //if (args.length != 0 && args[0].length() == 1) Task6(args[0].charAt(0));
        //Task8();
        //if (args.length != 0) Task7(args[0]);
        Task9(Stream.of(1, 2, 3, 4), Stream.of(99, 98, 97, 96, 95));
    }
}
