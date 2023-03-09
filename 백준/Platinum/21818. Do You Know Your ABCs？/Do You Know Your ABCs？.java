import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            int answer = 0;
            Set<Integer> set = new TreeSet<>();
            for (int x : arr) {
                set.add(x);
                for (int y : arr) {
                    if (x < y) {
                        set.add(y - x);
                    }
                }
            }

            for (int a : set) {
                for (int b : set) {
                    for (int c : set) {
                        if (a <= b && b <= c) {
                            List<Integer> res = List.of(a, b, c, a + b, b + c, a + c, a + b + c);
                            boolean flag = true;
                            for (int x : arr) {
                                if (!res.contains(x)) {
                                    flag = false;
                                }
                            }
                            if (flag) {
                                answer++;
                            }
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}