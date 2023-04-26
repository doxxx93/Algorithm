import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 16384;
    static int[] a = new int[MAX];
    static int n;

    static long solve() {
        Arrays.sort(a, 0, n);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int idx1 = i + 1, idx2 = n - 1, lidx2 = n;
            while (idx1 < idx2) {
                int sum = a[i] + a[idx1] + a[idx2];
                if (sum == 0) {
                    if (a[idx1] == a[idx2]) {
                        ans += idx2 - idx1;
                        idx1++;
                    } else {
                        if (lidx2 > idx2) {
                            lidx2 = idx2;
                            while (lidx2 - 1 >= 0 && a[lidx2 - 1] == a[idx2])
                                lidx2--;
                        }
                        ans += idx2 - lidx2 + 1;
                        idx1++;
                    }
                } else if (sum < 0)
                    idx1++;
                else
                    idx2--;
            }
        }
        return ans;
    }

    static String toString(long num) {
        if (num <= 0)
            return "0";
        StringBuilder ret = new StringBuilder();
        while (num > 0) {
            ret.append(num % 10);
            num /= 10;
        }
        return ret.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader in = new BufferedReader(new FileReader("ZeroSum.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ZeroSum.out")));
        String line = in.readLine();
        n = Integer.parseInt(line.trim());
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        System.out.println(toString(solve()));
        // out.println(toString(solve()));
        // out.close();
    }
}