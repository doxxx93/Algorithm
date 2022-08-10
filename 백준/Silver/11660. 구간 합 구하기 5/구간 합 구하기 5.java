import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] prefix = new int[n + 1][n + 1];

        for (int x = 1; x < n + 1; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y < n + 1; y++) {
                prefix[x][y] = prefix[x][y - 1] +prefix[x-1][y] -prefix[x-1][y-1] + Integer.parseInt(st.nextToken()) ;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1] + "\n");
        }
        System.out.println(sb);
    }
}