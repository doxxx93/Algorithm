import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 색, 좌표
        // 같은 색끼리 묶어서 정렬후 가까운 좌표와의 거리를 구한다.
        Map<Integer,List<Integer>> points = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        int sum = 0;
        for (List<Integer> point : points.values()) {
            Collections.sort(point);
            for (Integer x : point) {
                if (x.equals(point.get(0))) {
                    sum += point.get(1) - x;
                    continue;
                }
                if (x.equals(point.get(point.size() - 1))) {
                    sum += x - point.get(point.size() - 2);
                    continue;
                }
                sum += Math.min(x - point.get(point.indexOf(x) - 1), point.get(point.indexOf(x) + 1) - x);
            }
        }
//        System.out.println(points);
        System.out.println(sum);
    }
}
// 1 3 + 1 + 1 + 2+ 3 = 10
// 2 3 + 3 = 6