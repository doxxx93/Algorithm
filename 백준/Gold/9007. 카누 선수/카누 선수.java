import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[4][n];
            for (int i = 0; i < 4; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            }
            int[][] sum = new int[2][n * n];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum[0][idx] = arr[0][i] + arr[1][j];
                    sum[1][idx++] = arr[2][i] + arr[3][j];
                }
            }
            Arrays.sort(sum[0]);
            Arrays.sort(sum[1]);
            int s = 0;
            int e = sum[1].length - 1;
            int ans = sum[0][s] + sum[1][e];
            while (s < sum[0].length && e >= 0) {
                int cur = sum[0][s] + sum[1][e];
                int diff = cur - k;
                if (Math.abs(diff) == Math.abs(ans - k)) {
                    ans = Math.min(ans, cur);
                } else if (Math.abs(diff) < Math.abs(ans - k)) {
                    ans = cur;
                }
                if (cur >= k) {
                    e--;
                } else {
                    s++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}