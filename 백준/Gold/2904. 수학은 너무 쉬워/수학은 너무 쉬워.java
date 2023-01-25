import java.io.*;
import java.util.*;

class Main {

    static int MAX = 1000000;
    static int[] primes = new int[MAX + 5];
    static int n;
    static int[] arr = new int[105];
    static int[] A = new int[MAX];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            addFactors(arr[i]);
        }
        int result = solve();
        int prom = 0;
        for (int i = 0; i < n; i++) {
            prom += calPrimes(arr[i]);
        }
        System.out.println(result + " " + prom);
    }

    private static int calPrimes(int i) {
        int prime = 0;
        for (int j = 0; j < count; j++) {
            int br = A[j];
            int tr = primes[br];
            while (i % br == 0) {
                tr--;
                i /= br;
            }
            if (tr > 0) {
                prime += tr;
            }
        }
        return prime;
    }

    private static int solve() {
        int result = 1;
        count = 0;
        for (int i = 2; i <= MAX; i++) {
            primes[i] /= n;
            for (int j = 0; j < primes[i]; j++) {
                result *= i;
            }
            if (primes[i] > 0) {
                A[count++] = i;
            }
        }
        return result;
    }

    private static void addFactors(int x) {
        int factor = 2;
        int temp = x;
        while (factor * factor <= temp) {
            while (x % factor == 0) {
                primes[factor]++;
                x /= factor;
            }
            factor++;
        }
        if (x > 1) {
            primes[x]++;
        }
    }
}
