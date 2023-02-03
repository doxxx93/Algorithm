import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long[] prefixA = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixA[i] = prefixA[i - 1] + Long.parseLong(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        long[] prefixB = new long[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            prefixB[i] = prefixB[i - 1] + Long.parseLong(st.nextToken());
        }

        Map<Long, Long> subtotalA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                subtotalA.computeIfPresent(prefixA[j] - prefixA[i], (k, v) -> v + 1);
                subtotalA.putIfAbsent(prefixA[j] - prefixA[i], 1L);
            }
        }

        Map<Long, Long> subtotalB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                subtotalB.computeIfPresent(prefixB[j] - prefixB[i], (k, v) -> v + 1);
                subtotalB.putIfAbsent(prefixB[j] - prefixB[i], 1L);
            }
        }

        long count = 0;
        for (Long key : subtotalA.keySet()) {
            if (subtotalB.containsKey(t - key)) {
                count += subtotalA.get(key) * subtotalB.get(t - key);
            }
        }
        System.out.println(count);
    }
}