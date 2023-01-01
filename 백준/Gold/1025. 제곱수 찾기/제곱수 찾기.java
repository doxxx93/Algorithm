import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int ans = -1;

        for (int x = 1 - n; x < n; x++) {
            for (int y = 1 - m; y < m; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int temp = 0, curX = i, curY = j;
                        while (curX >= 0 && curY >= 0 && curX < n && curY < m) {
                            temp *= 10;
                            temp += map[curX][curY];
                            curX += x;
                            curY += y;
                            int root = (int) Math.sqrt(temp);
                            if (root * root == temp) {
                                ans = Math.max(ans, temp);
                            }
                        }
                    }
                }
            }
        }

        if (ans < 9) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 9) {
                        ans = 9;
                    } else if (map[i][j] == 4 && ans < 4) {
                        ans = 4;
                    } else if (map[i][j] == 1 && ans < 1) {
                        ans = 1;
                    } else if (map[i][j] == 0) {
                        ans = 0;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
