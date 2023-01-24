import java.io.*;
import java.util.*;

/**
 * 완전탐색
 * 최장 거리 -> Non-Poly
 * Back Tracking
 * <p>
 * 돌아다니는 과정 정보
 * 1. 현재 위치
 * 2. 밟았던 알파벳
 * 3. 이때까지 이동 길이
 */
public class Main {

    static int r, c, ans;
    static char[][] a;
    static boolean[] used;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new char[r][c];

        for (int i = 0; i < r; i++) {
            a[i] = br.readLine().toCharArray();
        }
        // 정답 변수,
        ans = 0;
        used = new boolean[26];

        backtracking(0, 0, 1);
        System.out.println(ans);
    }

    private static void backtracking(int x, int y, int count) {
        ans = Math.max(ans, count);
        used[a[x][y] - 'A'] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (0 <= nx && nx < r && 0 <= ny && ny < c && !used[a[nx][ny] - 'A']) {
                backtracking(nx, ny, count + 1);
            }
        }
        used[a[x][y] - 'A'] = false;
    }
}
