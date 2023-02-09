import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int count = arr[s] % 2 == 0 ? 0 : 1;
        int length = 0;
        while (true) {
            while (e < n - 1) {
                if (arr[e + 1] % 2 == 1) {
                    if (count < k) {
                        count++;
                    } else {
                        break;
                    }
                }
                e++;
            }

            if ( s==n ||e == n) {
                break;
            }
            length = Math.max(length, e - s + 1 - count);

            if (arr[s] % 2 == 1) {
                count--;
            }
            s++;
        }
        System.out.println(length);
    }
}
