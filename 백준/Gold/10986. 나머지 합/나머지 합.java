import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[m];
        long count = 0;
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(st.nextToken());;
            if (sum % m == 0) {
                count++;
            }
            arr[(int) (sum % m)]++;
        }
        for (int i = 0; i < m; i++) {
            count += arr[i] * (arr[i] - 1) / 2;
        }
        System.out.println(count);
    }
}