import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] amountOfWater;
    static boolean[][] cloudMap;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx2 = {-1, -1, 1, 1};
    static int[] dy2 = {-1, 1, 1, -1};
    static List<int[]> cloudList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // map n*n, input
        amountOfWater = new int[n][n];
        cloudMap = new boolean[n][n];
        cloudList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            amountOfWater[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        }

        cloudMap[n - 1][0] = true;
        cloudMap[n - 1][1] = true;
        cloudMap[n - 2][0] = true;
        cloudMap[n - 2][1] = true;
        getCloudList();
        // m turns
        while (m-- > 0) {
            String[] moveInfo = br.readLine().split(" ");
            int d = Integer.parseInt(moveInfo[0]);
            int s = Integer.parseInt(moveInfo[1]);
            move(d, s);

            rain();

            copy();

            make();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Arrays.stream(amountOfWater[i]).sum();
        }
        System.out.println(sum);
    }

    private static void getCloudList() {
        cloudList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloudMap[i][j]) {
                    cloudList.add(new int[]{i, j});
                }
            }
        }
    }

    private static void move(int d, int s) {
        for (int[] cloud : cloudList) {
            cloud[0] = (cloud[0] + s * dx[d] % n + n) % n;
            cloud[1] = (cloud[1] + s * dy[d] % n + n) % n;
        }
        getCloudMap();
    }

    private static void getCloudMap() {
        cloudMap = new boolean[n][n];
        for (int[] cloud : cloudList) {
            int x = cloud[0];
            int y = cloud[1];
            cloudMap[x][y] = true;
        }
    }

    private static void rain() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloudMap[i][j]) {
                    amountOfWater[i][j]++;
                }
            }
        }
    }

    private static void copy() {
        int[][] snapshot = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(amountOfWater[i], 0, snapshot[i], 0, n);
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (cloudMap[x][y]) {
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx2[k];
                        int ny = y + dy2[k];

                        if (!inRange(nx, ny)) {
                            continue;
                        }
                        if (snapshot[nx][ny] > 0) {
                            amountOfWater[x][y]++;
                        }
                    }
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private static void make() {
        cloudList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloudMap[i][j] || amountOfWater[i][j] < 2) {
                    continue;
                }
                amountOfWater[i][j] -= 2;
                cloudList.add(new int[]{i, j});
            }
        }
        getCloudMap();
    }

    private static void printMap(boolean[][] arr) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printMap(int[][] arr) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}