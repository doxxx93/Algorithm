import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int val = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                val++;
                sum += val;
            } else {
                val = 0;
            }
        }
        System.out.println(sum);
    }
}
