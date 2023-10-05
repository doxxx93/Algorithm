import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> routers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        routers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            routers.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(routers);

        int s = 1;
        int e = routers.get(n - 1) - routers.get(0) + 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (numberOfRouters(mid) < c) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(s - 1);
    }

    private static int numberOfRouters(int distance) {
        int count = 1;
        int prev = routers.get(0);

        for (int i = 1; i < routers.size(); i++) {
            int cur = routers.get(i);
            if (cur - prev >= distance) {
                count++;
                prev = cur;
            }
        }
        return count;
    }
}