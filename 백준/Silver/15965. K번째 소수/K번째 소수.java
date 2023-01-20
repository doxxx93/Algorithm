import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isPrime = new boolean[7368788];
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (long i = 2; i <= 500000; i++) {
            if (isPrime[(int) i]) {
                for (long j = i * i; j < 7368788; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }
        for (int i = 0; i < 7368788; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        System.out.println(primes.get(k - 1));
    }
}
