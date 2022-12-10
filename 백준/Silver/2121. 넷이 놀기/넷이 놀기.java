import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        List<Point> list = new ArrayList<>();
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Point(a, b));
            set.add(new Point(a, b));
        }
        int a, b;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            a = list.get(i).x;
            b = list.get(i).y;
            if (!set.contains(new Point(a + x, b))) {
                continue;
            }
            if (!set.contains(new Point(a, b + y))) {
                continue;
            }
            if (!set.contains(new Point(a + x, b + y))) {
                continue;
            }
            answer++;
        }
        System.out.println(answer);
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
