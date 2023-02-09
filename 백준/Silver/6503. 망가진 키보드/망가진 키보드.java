import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int m = Integer.parseInt(br.readLine());
            if (m == 0) {
                break;
            }
            char[] input = br.readLine().toCharArray();
            int[] check = new int[128];
            check[input[0]]++;
            int maxLength = 0;
            int count = 1;
            int s = 0;
            int e = 0;

            while (s < input.length && e < input.length) {
                if (count > m) {
                    check[input[s]]--;
                    if (check[input[s]] == 0) {
                        count--;
                    }
                    s++;
                } else {
                    maxLength = Math.max(maxLength, e - s + 1);
                    e++;
                    if (e < input.length) {
                        check[input[e]]++;
                        if (check[input[e]] == 1) {
                            count++;
                        }
                    }
                }
            }
            sb.append(maxLength).append("\n");
        }
        System.out.println(sb);
    }
}