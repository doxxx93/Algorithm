import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum = new int[2][n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[0][idx] = arr[0][i] + arr[1][j];
                sum[1][idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }
        Arrays.sort(sum[0]);
        Arrays.sort(sum[1]);
        long count = 0;
        int s = 0;
        int e = sum[1].length - 1;
        
        while (s < sum[0].length && e >= 0) {
            int sum1 = sum[0][s];
            int sum2 = sum[1][e];
            if (sum1 + sum2 == 0) {
                long c1 = 1;
                long c2 = 1;
                s++;
                e--;
                while (s < sum[0].length && sum[0][s] == sum1) {
                    c1++;
                    s++;
                }
                while (e >= 0 && sum[1][e] == sum2) {
                    c2++;
                    e--;
                }
                count += c1 * c2;
            } else if (sum1 + sum2 > 0) {
                e--;
            } else {
                s++;
            }
        }

        System.out.println(count);
    }
}