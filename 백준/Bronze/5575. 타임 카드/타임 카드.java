import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int h = h2 - h1;
            int m = m2 - m1;
            int s = s2 - s1;
            if (s < 0) {
                s += 60;
                m--;
            }
            if (m < 0) {
                m += 60;
                h--;
            }
            System.out.println(h + " " + m + " " + s);
        }
    }
}
