import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int m;
    static int[][] boards;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boards = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                boards[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(boards[n - 1][m - 1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int location[] = q.poll();
            visited[i][j] = true;

            for (int dir = 0; dir < 4; dir++) {
                int r = location[0] + dr[dir];
                int c = location[1] + dc[dir];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (boards[r][c] != 0 && !visited[r][c]) {
                        q.offer(new int[]{r, c});
                        visited[r][c] = true;
                        boards[r][c] = boards[location[0]][location[1]] + 1;
                    }
                }
            }
        }
    }
}

