import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        // 1 <= arr[i][j] <= k
        // right or down asc order
        if (n + m - 1 > k) {
            System.out.println("NO");
            return;
        }
        arr[0][0] = 1;

        StringBuilder sb = new StringBuilder();
        sb.append("YES").append("\n");
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(i + j + 1 + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


/*
    1   2   3   4   5       m
1   1   2   3   4   5   ... m
2   2   3   4   5   6   ... m+1
3   n+1 n+2 n+3 n+4 n+5 ... n+m+1
 */
