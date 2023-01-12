import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // -1000 ≤ A, B ≤ 1000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<Integer> x = new TreeSet<>();
        // x 는 항상 정수이다.
        // x * x + 2 * a * x + b = 0
        // (x - p)(x-q) = 0
        // p * q= b, -(p+q) = + 2 * a
        for (int i = -(int) Math.sqrt(1000); i * i <= 1000; i++) {
            if (i * i + 2 * a * i + b == 0) {
                x.add(i);
            }
        }
        for (Integer answer : x) {
            System.out.print(answer+ " ");
        }
        System.out.println();
    }
}
