import java.io.*;
import java.util.*;

public class Main {
    // a_i + a_i+1 + ... + a_j = b_i + b_i+1 + ... + b_j
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] prefixA = new long[n + 1];
        long[] prefixB = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixA[i] = prefixA[i - 1] + Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixB[i] = prefixB[i - 1] + Integer.parseInt(st.nextToken());
        }

        long count = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            long diff = prefixA[i] - prefixB[i];
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0L) + 1);
        }
        
        System.out.println(count);

    }
}