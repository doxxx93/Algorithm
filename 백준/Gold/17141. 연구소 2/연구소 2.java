import java.io.*;
import java.util.*;

public class Main {

    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int filled;
    static int[][] map;
    static boolean[][] visited;
    static int minTime;
    static List<int[]> virusList = new ArrayList<>();
    static int[] selectedVirus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        selectedVirus = new int[m];

        int wallCount = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == VIRUS) {
                    virusList.add(new int[]{i, j});
                }
                if (map[i][j] == WALL) {
                    wallCount++;
                }
            }
        }

        filled = n * n - wallCount - m;

        if (filled == 0) {
            System.out.println(0);
            return;
        }

        minTime = Integer.MAX_VALUE;

        int size = virusList.size();

        combination(0, size, 0);

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void combination(int start, int size, int index) {
        if (index == m) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
            for (int i = 0; i < m; i++) {
                int[] virus = virusList.get(selectedVirus[i]);
                visited[virus[0]][virus[1]] = true;
            }
            minTime = Math.min(minTime, bfs());
            return;
        }

        for (int i = start; i < size; i++) {
            selectedVirus[index] = i;
            combination(i + 1, size, index + 1);
        }
    }

    private static int bfs() {
        int time = 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int[] ints : virusList) {
            if (visited[ints[0]][ints[1]]) {
                queue.offer(ints);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    if (visited[nx][ny] || map[nx][ny] == WALL) {
                        continue;
                    }

                    if (map[nx][ny] == EMPTY || map[nx][ny] == VIRUS) {
                        count++;
                    }

                    if (count == filled) {
                        return time;
                    }

                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
