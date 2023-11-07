import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int windowSum = 0;

        for (int i = 0; i < x; i++) {
            windowSum += arr[i];
        }

        int max = windowSum;
        int count = (max > 0) ? 1 : 0;

        for (int i = x; i < n; i++) {
            windowSum = windowSum - arr[i - x] + arr[i];
            if (windowSum == max) {
                count++;
            } else if (windowSum > max) {
                max = windowSum;
                count = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
