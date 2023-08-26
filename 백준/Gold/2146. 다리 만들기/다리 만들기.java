import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int minLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int kind = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (map[i][j] == 0) {
                    continue;
                }
                bfs(i, j, kind++);
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        minLength = Integer.MAX_VALUE;

        // minLength of bridge that connects different islands
        for (int i = 1; i < kind; i++) {
            Queue<int[]> q = new LinkedList<>();
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == i) {
                        q.offer(new int[]{j, k});
                        visited[j][k] = true;
                    }
                }
            }
            int length = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }
                        if (visited[nx][ny]) {
                            continue;
                        }
                        if (map[nx][ny] == i) {
                            continue;
                        }
                        if (map[nx][ny] != 0) {
                            minLength = Math.min(minLength, length);
                            break;
                        }
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
                length++;
            }
        }

        System.out.println(minLength);
    }

    private static void bfs(int i, int j, int kind) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = kind;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    continue;
                }
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                map[nx][ny] = kind;
            }
        }
    }
}
