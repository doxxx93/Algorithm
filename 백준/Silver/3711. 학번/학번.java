import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int g = Integer.parseInt(br.readLine());

            int[] arr = new int[g];
            for (int i = 0; i < g; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int k = 1;
            while (true) {
                boolean flag = true;
                List<Integer> al = new ArrayList<>();
                for (int i = 0; i < g; i++) {
                    if (al.contains(arr[i] % k)) {
                        flag = false;
                        break;
                    }
                    al.add(arr[i] % k);
                }
                if (flag) {
                    sb.append(k).append("\n");
                    break;
                }
                k++;
            }
        }
        System.out.println(sb);
    }
}