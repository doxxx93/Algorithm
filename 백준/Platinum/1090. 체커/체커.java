import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[][] distance = new int[n * n][n];
        int[][] sum = new int[n][n * n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    distance[(n * i + j)][k] = Math.abs(arr[i][0] - arr[k][0]) + Math.abs(arr[j][1] - arr[k][1]);
                }
            }
        }
        for (int i = 0; i < n * n; i++) {
            Arrays.sort(distance[i]);
        }
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    sum[j][i] = distance[i][j];
                    continue;
                }
                sum[j][i] = sum[j - 1][i] + distance[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * n; j++) {
                sum[i][0] = Math.min(sum[i][0], sum[i][j]);
            }
            System.out.print(sum[i][0] + " ");
        }
    }
}