import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i] > a[j]) {
                    continue;
                }
                a[j] -= b[i];
                break;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += a[i];
        }
        System.out.println(count);
    }
}