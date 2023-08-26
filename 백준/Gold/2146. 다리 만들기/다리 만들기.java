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

        minLength = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Queue<int[]> q = new LinkedList<>();
                List<int[]> sameIsland = new ArrayList<>();
                if (visited[i][j]) {
                    continue;
                }
                if (map[i][j] == 0) {
                    continue;
                }
                q.add(new int[]{i, j});
                sameIsland.add(new int[]{i, j});
                visited[i][j] = true;
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
                        q.add(new int[]{nx, ny});
                        sameIsland.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

                boolean[][] tempVisited = new boolean[N][N];
                Queue<int[]> tempQueue = new LinkedList<>();
                for (int[] start : sameIsland) {
                    tempVisited[start[0]][start[1]] = true;
                    tempQueue.add(new int[]{start[0], start[1], 0});
                }

                while (!tempQueue.isEmpty()) {
                    int[] cur = tempQueue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }
                        if (tempVisited[nx][ny]) {
                            continue;
                        }
                        if (map[nx][ny] == 1 && !visited[nx][ny]) {
                            minLength = Math.min(minLength, cur[2]);
                            tempQueue.clear();
                            break;
                        }
                        if (map[nx][ny] == 0) {
                            tempVisited[nx][ny] = true;
                            tempQueue.add(new int[]{nx, ny, cur[2] + 1});
                        }
                    }
                }

            }
        }

        System.out.println(minLength);
    }
}
