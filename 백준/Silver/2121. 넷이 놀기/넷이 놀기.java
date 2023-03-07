import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        // sort points by x then y
        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p1[0] - p2[0];
        });

        // count number of points that can make rectangle size of a x b
        // using two pointers
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            // if there are (x + a , y) && (x + a, y + b) && (x, y + b) -> count++
            if (!contains(points, x + a, y) || !contains(points, x + a, y + b) || !contains(points,
                x, y + b)) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }

    private static boolean contains(int[][] points, int x, int y) {
        int l = 0;
        int r = points.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (points[mid][0] == x && points[mid][1] == y) {
                return true;
            }
            if (points[mid][0] < x || (points[mid][0] == x && points[mid][1] < y)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}