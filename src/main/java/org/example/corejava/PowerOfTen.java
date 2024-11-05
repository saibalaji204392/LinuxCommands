package corejava;

public class PowerOfTen {
    public static void main(String[] args) {
        System.out.println(isPowerOfTen(10));
        System.out.println(isPowerOfTen(100));
        System.out.println(isPowerOfTen(50));
        System.out.println(isPowerOfTen(1));
        System.out.println(isPowerOfTen(0));
    }

    public static boolean isPowerOfTen(int n) {
        if (n <= 0) return false;
        while (n % 10 == 0) {
            n /= 10;
        }
        return n == 1;
    }
}
