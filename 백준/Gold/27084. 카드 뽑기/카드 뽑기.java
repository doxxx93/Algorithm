import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] cnt = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            cnt[num]++;
        }
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            ans = (ans * (cnt[i] + 1)) % 1000000007;
        }
        System.out.println((ans + 1000000007 - 1) % 1000000007);
    }
}
