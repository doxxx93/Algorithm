import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int max = Integer.MIN_VALUE;
    static int[][] map = new int[503][503];
    static boolean[][] visited;

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {0, 1, 0, -1};
    static final String[][][] block = {{{"1111", "0000", "0000", "0000"},},
        {{"1000", "1000", "1000", "1000"},}, {{"1100", "1100", "0000", "0000"},},
        {{"1000", "1000", "1100", "0000"},}, {{"1110", "1000", "0000", "0000"},},
        {{"1100", "0100", "0100", "0000"},}, {{"0010", "1110", "0000", "0000"},},
        {{"0100", "0100", "1100", "0000"},}, {{"1000", "1110", "0000", "0000"},},
        {{"1100", "1000", "1000", "0000"},}, {{"1110", "0010", "0000", "0000"},},
        {{"1000", "1100", "0100", "0000"},}, {{"0110", "1100", "0000", "0000"},},
        {{"0100", "1100", "1000", "0000"},}, {{"1100", "0110", "0000", "0000"},},
        {{"1110", "0100", "0000", "0000"},}, {{"0100", "1100", "0100", "0000"},},
        {{"0100", "1110", "0000", "0000"},}, {{"1000", "1100", "1000", "0000"},}};

    static int getCount(int sy, int sx, int k) {
        int ret = 0;
        for (int y = 0; y < 4; ++y) {
            for (int x = 0; x < 4; ++x) {
                ret += (block[k][0][y].charAt(x) - '0') * map[sy + y][sx + x];
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int y = 0; y < n; ++y) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; ++x) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = n; y < n + 3; ++y) {
            Arrays.fill(map[y], -100000);
        }

        for (int y = 0; y < n + 3; ++y) {
            for (int x = m; x < m + 3; ++x) {
                map[y][x] = -100000;
            }
        }

        int ret = 0;
        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                for (int k = 0; k < 19; ++k) {
                    ret = Math.max(ret, getCount(y, x, k));
                }
            }
        }

        System.out.println(ret);
    }
}