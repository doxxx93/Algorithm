import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int backwardA = 0;
        while (a > 0) {
            backwardA += a % 10;
            a /= 10;
            backwardA *= 10;
        }
        int backwardB = 0;
        while (b > 0) {
            backwardB += b % 10;
            b /= 10;
            backwardB *= 10;
        }
        int answer = Math.max(backwardA, backwardB);
        System.out.println(answer / 10);
    }
}