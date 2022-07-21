import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        // 현재 몸무게의 제곱 - 기억 하고 있던 몸무게의 제곱
        List<Integer> arr = new ArrayList<>();

        int s = 1;
        int e = 1;

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while (s <= e && e <= 100000) {
            int gap = e * e - s * s;
            if (gap == g) {
                flag = true;
                sb.append(e).append("\n");
                e++;
            } else if (gap > g) {
                s++;
            } else {
                e++;
            }
        }
        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println("-1");
        }
    }
}
