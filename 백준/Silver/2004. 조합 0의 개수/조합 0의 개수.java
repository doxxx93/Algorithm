import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(count(n, m, 5), count(n, m, 2)));
    }

    private static int count(int n, int m, int k) {
        return get(n, k) - get(m, k) - get(n - m, k);
    }

    private static int get(int n, int k) {

        int count = 0;

        while (n >= k) {
            count += n / k;
            n /= k;
        }
        return count;
    }
}
