import static java.lang.Math.abs;
import static java.lang.StrictMath.floorMod;


public class GCD {
    public static int gcd_perc(int a, int b) {
        return b == 0 ? a : gcd_perc(b, a % b);
    }

    public static int gcd_floorMod(int a, int b) {
        return b == 0 ? a : gcd_floorMod(b, floorMod(a, b));
    }

    public static int gcd_rem(int a, int b) {
        return b == 0 ? a : gcd_rem(b, abs(a % b));
    }
}
