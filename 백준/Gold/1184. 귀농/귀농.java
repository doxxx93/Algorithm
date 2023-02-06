import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] prefix;
    static Map<Integer, Integer> bio;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prefix = new int[n + 1][n + 1];
        bio = new HashMap<>();
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                prefix[i][j] =
                    prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + Integer.parseInt(
                        st.nextToken());
            }
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int x = 1; x < i; x++) {
                    for (int y = 1; y < j; y++) {
                        bio.merge(area(x, y, i - 1, j - 1), 1, Integer::sum);
                    }
                }
                for (int x = i; x <= n; x++) {
                    for (int y = j; y <= n; y++) {
                        count += bio.getOrDefault(area(i, j, x, y), 0);
                    }
                }
                for (int x = 1; x < i; x++) {
                    for (int y = 1; y < j; y++) {
                        bio.merge(area(x, y, i - 1, j - 1), -1, Integer::sum);
                    }
                }
                for (int x = 1; x < i; x++) {
                    for (int y = j; y <= n; y++) {
                        bio.merge(area(x, j, i - 1, y), 1, Integer::sum);
                    }
                }
                for (int x = i; x <= n; x++) {
                    for (int y = 1; y < j; y++) {
                        count += bio.getOrDefault(area(i, y, x, j - 1), 0);
                    }
                }
                for (int x = 1; x < i; x++) {
                    for (int y = j; y <= n; y++) {
                        bio.merge(area(x, j, i - 1, y), -1, Integer::sum);
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static int area(int x1, int y1, int x2, int y2) {
        return (prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1]);
    }
}