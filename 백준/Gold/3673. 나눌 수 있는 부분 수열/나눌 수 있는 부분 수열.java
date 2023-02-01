import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            long[] prefix = new long[n + 1];
            st = new StringTokenizer(br.readLine());
            long count = 0;
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
                if (prefix[i] % d == 0) {
                    count++;
                }
            }
            Map<Long, Long> map = new TreeMap<>();
            for (int i = 1; i <= n; i++) {
                long mod = prefix[i] % d;
                if (map.containsKey(mod)) {
                    count += map.get(mod);
                }
                map.put(mod, map.getOrDefault(mod, 0L) + 1);
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
}