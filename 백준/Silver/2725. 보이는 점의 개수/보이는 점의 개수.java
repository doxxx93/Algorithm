import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] points = new int[1001];
        points[0] = 0;
        points[1] = 2;
        for (int i = 2; i <= 1000; i++) {
            int n = 0;
            for (int j = 1; j <= i; j++) {
                if (gcd(i, j) == 1) {
                    n++;
                }
            }
            points[i] = points[i - 1] + n;
        }
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (c-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(points[n] * 2 - 1).append("\n");
        }
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}