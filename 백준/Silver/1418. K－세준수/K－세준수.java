import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] maxPrimeFactors = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (maxPrimeFactors[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    maxPrimeFactors[j] = i;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (k >= maxPrimeFactors[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
