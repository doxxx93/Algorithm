import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long l = 1;
        long r = k;

        while (l < r) {
            long mid = (l + r) / 2;
            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid /i , n);
            }
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}