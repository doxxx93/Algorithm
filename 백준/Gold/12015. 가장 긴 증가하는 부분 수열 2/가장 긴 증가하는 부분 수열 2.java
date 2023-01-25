import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lis = new int[n];

        lis[0] = seq[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            int key = seq[i];

            if (lis[len - 1] < key) {
                len++;
                lis[len - 1] = key;
                continue;
            }
            int l = 0;
            int r = len;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (lis[mid] < key) {
                    l = mid + 1;
                    continue;
                }
                r = mid;
            }
            lis[l] = key;
        }
        System.out.println(len);
    }
}
