import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] sleep = new int[n];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                sleep[i] = Integer.parseInt(st.nextToken());
                sum += sleep[i];
            }

            int res = 0;
            for (int i = 1; i <= sum; i++) {
                if (sum % i == 0) {
                    int current = i;
                    boolean isValid = true;
                    for (int j = 0; j < n; j++) {
                        if (sleep[j] > current) {
                            isValid = false;
                            break;
                        } else {
                            current -= sleep[j];
                            if (current == 0) {
                                current = i;
                            }
                        }
                    }
                    if (current != i) {
                        isValid = false;
                    }
                    if (isValid) {
                        res = n -(sum / i);
                        break;
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}