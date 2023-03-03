import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(1, n));
    }

    private static BigInteger fact(int a, int b) {
        BigInteger res = BigInteger.valueOf(a);
        if (a < b) {
            int m = (a + b) / 2;
            res = fact(a, m).multiply(fact(m + 1, b));
        }
        return res;
    }
}