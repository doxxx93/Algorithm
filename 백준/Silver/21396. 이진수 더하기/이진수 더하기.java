import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> xorMap = new TreeMap<>();

            long count = 0;
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = (a ^ x);
                count += xorMap.getOrDefault(b, 0);
                xorMap.put(a, xorMap.getOrDefault(a, 0) + 1);
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
