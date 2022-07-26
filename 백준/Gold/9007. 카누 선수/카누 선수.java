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

            merge = new int[2][n * n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    merge[0][i * n + j] = arr[0][i] + arr[1][j];
                    merge[1][i * n + j] = arr[2][i] + arr[3][j];
                }
            }
            for (int i = 0; i < 2; i++) {
                Arrays.sort(merge[i]);
            }
            sb.append(binarySearch(n, k)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int n, int k) {
        int v = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < n * n; i++) {
            int a = merge[0][i];
            int s = 0;
            int e = n * n - 1;

            while (s < e) {
                int m = (s + e) / 2;
                if (a + merge[1][m] < k) {
                    s = m + 1;
                } else {
                    e = m;
                }
            }
            if (s > 0) {
                if (v >= Math.abs(a + merge[1][s - 1] - k)) {
                    v = Math.abs(a + merge[1][s - 1] - k);
                    answer = a + merge[1][s - 1];
                }
            }
            if (v > Math.abs(a + merge[1][s] - k)) {
                v = Math.abs(a + merge[1][s] - k);
                answer = a + merge[1][s];
            }
        }
        return answer;
    }
}