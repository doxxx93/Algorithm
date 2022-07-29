import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, arr[i]);
        }

        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = 0;

            for (int i = 0; i < m; i++) {
                if (arr[i] % mid == 0) {
                    sum += arr[i] / mid;
                } else {
                    sum += arr[i] / mid + 1;
                }
            }

            if (sum > n) {
                l = mid + 1;
            } else {
                r = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}