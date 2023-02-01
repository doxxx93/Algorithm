import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][][] prefix = new int[n + 1][n + 1][11];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < 11; k++) {
                    prefix[i][j][k] += prefix[i][j - 1][k];
                    prefix[i][j][k] += prefix[i - 1][j][k];
                    prefix[i][j][k] -= prefix[i - 1][j - 1][k];
                }
                prefix[i][j][arr[i][j]]++;
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int count = 0;
            int[] tmp = new int[11];
            for (int i = 1; i < 11; i++) {
                tmp[i] = prefix[x2][y2][i];
            }
            for (int i = 1; i < 11; i++) {
                tmp[i] -= prefix[x1 - 1][y2][i];
                tmp[i] -= prefix[x2][y1 - 1][i];
                tmp[i] += prefix[x1 - 1][y1 - 1][i];
            }
            for (int i = 1; i < 11; i++) {
                if (tmp[i] > 0) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
