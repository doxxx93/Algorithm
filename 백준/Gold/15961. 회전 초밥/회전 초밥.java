import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] ate = new int[d + 1];
        ate[c]++;
        int count = 1;
        int s = 0;
        int e = k - 1;
        for (int i = 0; i < k; i++) {
            if (ate[arr[i]]++ == 0) {
                count++;
            }
        }
        int answer = count;
        while (s < n - 1) {
            if (ate[arr[s++]]-- == 1) {
                count--;
            }
            e = (e + 1) % n;
            if (ate[arr[e]]++ == 0) {
                count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}