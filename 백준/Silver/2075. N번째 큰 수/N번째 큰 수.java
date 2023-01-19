import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        // find nth largest number
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int dir = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ans = new int[n * n];
        int idx = 0;
//        while (true) {
//            ans[idx++] = arr[x][y];
//            arr[x][y] = 0;
//            int nx = x + dx[dir];
//            int ny = y + dy[dir];
//            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 0) {
//                dir = (dir + 1) % 4;
//                nx = x + dx[dir];
//                ny = y + dy[dir];
//            }
//            if (arr[nx][ny] == 0) {
//                break;
//            }
//            x = nx;
//            y = ny;
//        }
        // ArrayIndexOutOfBoundsException safe
        while (true) {
            ans[idx++] = arr[x][y];
            arr[x][y] = 0;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }
        Arrays.sort(ans);
        System.out.println(ans[n * n - n]);
    }
}
