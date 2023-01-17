import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long res = 0;
        for (long i = 0; b > 0; i++) {
            res += oddNumber(a, b) * (1L << i);
            a = (a + 1) / 2;
            b = b / 2;
        }
        System.out.println(res);
    }

    private static long oddNumber(long a, long b) {
        if (a % 2 == 0 && b % 2 == 0) {
            return (b - a) / 2;
        }
        if (a % 2 == 1 && b % 2 == 0 || a % 2 == 0 && b % 2 == 1) {
            return (b - a + 1) / 2;
        }
        return (b - a) / 2 + 1;
    }
}
