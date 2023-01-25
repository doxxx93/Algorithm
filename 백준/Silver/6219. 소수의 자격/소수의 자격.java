import java.io.*;
import java.util.*;

public class Main {

    static boolean[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        primes = new boolean[b + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= b; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= b; j += i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (primes[i]) {
                if (contains(i, d)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean contains(int i, int d) {
        while (i > 0) {
            if (i % 10 == d) {
                return true;
            }
            i /= 10;
        }
        return false;
    }
}
