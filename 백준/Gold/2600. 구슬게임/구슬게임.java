import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] b = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[501];
        dp[0] = 0;
        boolean[] visited = new boolean[4];

        for (int i = 1; i <= 500; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 3; j++) {
                if (i - b[j] >= 0) {
                    visited[dp[i - b[j]]] = true;
                }
            }

            int m = 0;
            while (visited[m]) {
                m++;
            }
            dp[i] = m;
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            if ((dp[k1] ^ dp[k2]) == 0) {
                System.out.println("B");
                continue;
            }
            System.out.println("A");
        }
    }
}
