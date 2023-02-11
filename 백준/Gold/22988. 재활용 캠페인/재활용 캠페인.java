import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        List<Long> al = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            if (a >= x) {
                count++;
                continue;
            }
            al.add(a);
        }
        Collections.sort(al);

        int s = 0;
        int e = al.size() - 1;
        int count2 = 0;
        while (s < e) {
            long sum = al.get(s) + al.get(e);
            if (2 * sum >= x) {
                count2++;
                s++;
                e--;
            } else {
                s++;
            }
        }

        System.out.println(count + count2 + (al.size() - 2 * count2) / 3);
    }
}