import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][3];
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            arr[i][2] = Long.parseLong(st.nextToken());

            min = Math.min(min, arr[i][0]);
            max = Math.max(max, arr[i][1]);
        }

        long l = min;
        long r = max;
        long answer = 0;
        long count = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum=0;
            for (int i = 0; i < n; i++) {
                if (mid >= arr[i][0]) {
                    sum += (Math.min(mid, arr[i][1]) - arr[i][0]) / arr[i][2] + 1;
                }
            }
            if (sum % 2 == 1) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (answer == 0) {
            System.out.println("NOTHING");
        } else {
            long large = 0;
            for (int i = 0; i < n; i++) {
                if (answer >= arr[i][0]) {
                    large += (Math.min(answer, arr[i][1]) - arr[i][0]) / arr[i][2] + 1;
                }
            }
            long small = 0;
            for (int i = 0; i < n; i++) {
                if (answer - 1 >= arr[i][0]) {
                    small += (Math.min(answer-1, arr[i][1]) - arr[i][0]) / arr[i][2] + 1;
                }
            }
            count = large - small;
            System.out.println(answer + " " + count);
        }
    }
}
