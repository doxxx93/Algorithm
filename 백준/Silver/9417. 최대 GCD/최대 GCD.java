import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            long max = Long.MIN_VALUE;
            long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong)
                .toArray();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    max = Math.max(gcd(arr[i], arr[j]), max);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
