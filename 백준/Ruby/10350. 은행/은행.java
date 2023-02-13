import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * 2 + 1];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum += arr[i] = arr[i + n] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        for (int i = 1; i <= n; i++) {
            long value = 0;
            for (int j = i; j < i + n; j++) {
                value += arr[j];
                if (value < 0) {
                    count += (-value - 1) / sum + 1;
                }
            }
        }
        System.out.println(count);
    }
}