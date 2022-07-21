import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        List<Integer> al = new ArrayList<>(n + 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }
        al.add(n, 0);

        int s = 0;
        int e = 0;
        int sum = al.get(0);
        int length = Integer.MAX_VALUE;
        while (s <= e && e < n) {
            if (sum < t) {
                sum += al.get(++e);
            } else {
                length = Math.min(length, e - s + 1);
                sum -= al.get(s++);
            }
        }
        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}
