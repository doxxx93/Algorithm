import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            final int[] ints = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt)
                .toArray();
            if (m >= 0) {
                System.arraycopy(ints, 0, arr[i + 1], 1, m);
            }
        }
        int maxArea = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = arr[i - 1][j] + 1;
                } else {
                    arr[i][j] = 0;
                }

                if (arr[i][j] > 0) {
                    int min = arr[i][j];
                    for (int k = j; k >= 1; k--) {
                        if (arr[i][k] == 0) {
                            break;
                        }
                        min = Math.min(min, arr[i][k]);
                        maxArea = Math.max(maxArea, min * (j - k + 1));
                    }
                }
            }
        }
        System.out.println(maxArea);
    }
}