import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Long x = Long.parseLong(st.nextToken());

        List<Long> al = new ArrayList<>();
        int count = 0;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            long i = Long.parseLong(st.nextToken());
            if (i >= x) {
                count++;
                continue;
            }
            al.add(i);
        }

        Collections.sort(al);

        int s = 0;
        int e = al.size() - 1;
        int count2 = 0;
        while (s < e) {
            if (2 * (al.get(s) + al.get(e)) >= x) {
                count2++;
                e--;
                s++;
            } else if (2 * (al.get(s) + al.get(e)) < x) {
                s++;
            }
        }

        System.out.println(count + count2 + (al.size() - 2 * count2) / 3);
    }
}
