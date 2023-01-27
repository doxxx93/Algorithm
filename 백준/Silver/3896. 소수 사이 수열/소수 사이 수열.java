import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int MAX = 1299710;
        boolean[] primes = new boolean[MAX + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    primes[j] = false;
                }
            }
        }

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            if (primes[k]) {
                sb.append(0).append("\n");
                continue;
            }
            int l = k;
            int r = k;
            int count = 0;
            while (!primes[l] && l > 1) {
                count++;
                l--;
            }
            while (!primes[r]) {
                count++;
                r++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}