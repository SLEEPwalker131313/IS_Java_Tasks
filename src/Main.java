import java.io.IOException;
import java.util.Scanner;

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

    public static void main(String[] args) throws IOException {
        //Task1();
        //if (args.length != 0) Task2(args[0]);
        //Task3();
        //Task4();
        //Task5();
        if (args.length != 0 && args[0].length() == 1) Task6(args[0].charAt(0));
    }
}
