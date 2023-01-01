import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n * 2 + 1];
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            arr[i + n] = arr[i];
        }

        long count = 0;
        for (int i = 1; i <= n; i++) {
            long value = 0;
            for (int j = i; j < i + n; j++) {
                value += arr[j];
                if (value < 0) {
                    long x = -value;
                    count += (x - 1) / sum + 1;
                }
            }
        }
        System.out.println(count);
    }
}