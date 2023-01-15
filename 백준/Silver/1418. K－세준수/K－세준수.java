import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int x = getMaxPrimeFactor(i);
            if (k >= x) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int getMaxPrimeFactor(int x) {
        int max = 0;
        for (int i = 2; i <= x; i++) {
            while (x % i == 0) {
                max = Math.max(max, i);
                x /= i;
            }
        }
        return max;
    }
}
