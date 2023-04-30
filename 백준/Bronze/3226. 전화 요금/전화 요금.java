import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] time = st.nextToken().split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int end = Integer.parseInt(st.nextToken()) + start;
            while (start < end) {
                if (start >= 420 && start < 1140) {
                    sum += 10;
                } else {
                    sum += 5;
                }
                start++;
            }
        }
        System.out.println(sum);
    }
}
