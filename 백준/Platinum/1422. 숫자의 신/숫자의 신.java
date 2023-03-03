import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < k; i++) {
            String input = br.readLine();
            list.add(input);
            max = Math.max(max, Integer.parseInt(input));
        }
        list.sort((a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (String s : list) {
            sb.append(s);
            if (flag && Integer.parseInt(s) == max) {
                sb.append(s.repeat(Math.max(0, n - k)));
                flag = false;
            }
        }
        System.out.println(sb);
    }
}