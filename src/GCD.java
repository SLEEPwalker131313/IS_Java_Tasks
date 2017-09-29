import static java.lang.Math.abs;
import static java.lang.StrictMath.floorMod;


class GCD {
    static int gcd_perc(int a, int b) {
        return b == 0 ? a : gcd_perc(b, a % b);
    }

    static int gcd_floorMod(int a, int b) {
        return b == 0 ? a : gcd_floorMod(b, floorMod(a, b));
    }

    static int gcd_rem(int a, int b) {
        return b == 0 ? a : gcd_rem(b, abs(a % b));
    }
}
