import java.io.*;
import java.util.*;

public class Main {

    private static String I = "I";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                String query = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                if (query.equals(I)) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (x == 1) {
                        int key = map.lastKey();
                        if (map.get(key) == 1) {
                            map.remove(key);
                        } else {
                            map.compute(key, (k, v) -> v - 1);
                        }
                    } else {
                        int key = map.firstKey();
                        if (map.get(key) == 1) {
                            map.remove(key);
                        } else {
                            map.compute(key, (k, v) -> v - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}