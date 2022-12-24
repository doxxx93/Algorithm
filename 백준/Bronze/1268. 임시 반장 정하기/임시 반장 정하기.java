import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] room = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 5; k++) {
                    if (room[i][k] == room[j][k]) {
                        count[i]++;
                        break;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, count[i]);
        }
        for (int i = 0; i < n; i++) {
            if (count[i] == max) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
