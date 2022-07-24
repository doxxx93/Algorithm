import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 0; i < b; i++) {
            arr[Integer.parseInt(br.readLine())] = 1;
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }

        int m = count;
        for (int i = 1; i + k - 1 < n; i++) {
            if (arr[i] == 1) {
                count--;
            }
            if (arr[i + k] == 1) {
                count++;
            }
            m = Math.min(m, count);
        }
        System.out.println(m);
    }
}
