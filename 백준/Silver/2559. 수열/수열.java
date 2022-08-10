import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> prefix = new ArrayList<>();
        prefix.add(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            prefix.add(prefix.get(i-1) + Integer.parseInt(st.nextToken()));
        }

        int max = Integer.MIN_VALUE;

        for (int i = k; i < n+1; i++) {
            int temp = prefix.get(i) - prefix.get(i-k);
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}
