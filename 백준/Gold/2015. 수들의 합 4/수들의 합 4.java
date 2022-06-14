import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

            if (sum[i] == K) {
                answer++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (map.containsKey(sum[i] - K)) {
                answer += map.get(sum[i] - K);
            }
            if (map.containsKey(sum[i])) {
                map.put(sum[i], map.get(sum[i]) + 1);
            } else {
                map.put(sum[i], 1L);
            }
        }

        System.out.println(answer);
    }
}