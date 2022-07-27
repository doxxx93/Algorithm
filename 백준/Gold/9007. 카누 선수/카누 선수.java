import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[][] merge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[4][n];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] sum1 = new int[n * n];
            int[] sum2 = new int[n * n];

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum1[cnt] = arr[0][i] + arr[1][j];
                    sum2[cnt++] = arr[2][i] + arr[3][j];
                }
            }

            Arrays.sort(sum1);
            Arrays.sort(sum2);

            int s = 0;
            int e = sum2.length - 1;
            int ans = sum1[s] + sum2[e];

            while ((s < sum1.length) && (e >= 0)) {
                if (Math.abs(ans - k) == Math.abs(sum1[s] + sum2[e] - k)) {
                    ans = Math.min(ans, sum1[s] + sum2[e]);
                } else if (Math.abs(ans - k) > Math.abs(sum1[s] + sum2[e] - k)) {
                    ans = sum1[s] + sum2[e];
                }

                if (sum1[s] + sum2[e] >= k) {
                    e -= 1;
                } else {
                    s += 1;
                }
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }
}