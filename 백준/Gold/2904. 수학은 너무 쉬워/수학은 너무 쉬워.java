import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] primes = new int[1000001];
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            fac(arr[i], primes);
        }
        List<Integer> pN = new ArrayList<>();
        List<Integer> pV = new ArrayList<>();
        long gcd = 1;
        for (int i = 2; i < 1000001; i++) {
            if (primes[i] >= n) {
                pN.add(i);
                for (int j = 0; j < primes[i] / n; j++) {
                    gcd *= i;
                }
                pV.add(primes[i] / n);
            }
        }
        int count = 0;
        for (int i = 0; i < pN.size(); i++) {
            int p = pN.get(i);
            int v = pV.get(i);
            for (int j = 0; j < n; j++) {
                int countI = 0;
                while (arr[j] % p == 0) {
                    arr[j] /= p;
                    countI++;
                }
                if (countI >= v) {
                    continue;
                }
                count += v - countI;
            }
        }
        System.out.println(gcd + " " + count);
    }
    private static void fac(int i, int[] arr) {
        for (int j = 2; j * j <= i; j++) {
            while (i % j == 0) {
                arr[j]++;
                i /= j;
            }
        }
        if (i != 1) {
            arr[i]++;
        }
    }
}