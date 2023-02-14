import java.io.*;
import java.util.*;

public class Main {

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a.x));

        int minArea = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minY = Math.min(points[i].y, points[j].y) - 1;
                int maxY = Math.max(points[i].y, points[j].y) + 1;
                int minHeight = maxY - minY;

                List<Integer> index = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (points[k].y > minY && points[k].y < maxY) {
                        index.add(k);
                    }
                }

                if (index.size() < n / 2) {
                    continue;
                }

                int minWidth = Integer.MAX_VALUE;
                for (int k = n / 2 - 1; k < index.size(); k++) {
                    int width =
                        (points[index.get(k)].x + 1) - (points[index.get(k - n / 2 + 1)].x - 1);
                    minWidth = Math.min(minWidth, width);
                }
                minArea = Math.min(minArea, minWidth * minHeight);
            }
        }
        System.out.println(minArea);
    }
}