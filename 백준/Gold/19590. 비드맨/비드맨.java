import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        sum -= max;

        if (sum >= max) {
            if ((sum + max) % 2 == 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        } else {
            System.out.println(max - sum);
        }
    }
}
