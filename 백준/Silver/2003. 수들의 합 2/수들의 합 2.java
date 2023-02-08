import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int total = a[0];
        int count = 0;
        while (e < n) {
            if (total < m) {
                e++;
                total += a[e];
            } else if (total > m) {
                total -= a[s];
                s++;
            } else {
                count++;
                total -= a[s];
                s++;
                e++;
                total += a[e];
            }
        }
        System.out.println(count);
    }
}
