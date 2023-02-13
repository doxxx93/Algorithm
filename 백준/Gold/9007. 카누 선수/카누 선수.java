import java.io.*;
import java.util.*;

public class Main {

    static final FastScanner fs = new FastScanner();
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int t = fs.nextInt();
        while (t-- > 0) {
            int k = fs.nextInt();
            int n = fs.nextInt();
            int[] arr1 = fs.readArray(n);
            int[] arr2 = fs.readArray(n);
            int[] arr3 = fs.readArray(n);
            int[] arr4 = fs.readArray(n);
            int[] sum1 = new int[n * n];
            int[] sum2 = new int[n * n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum1[index] = arr1[i] + arr2[j];
                    sum2[index] = arr3[i] + arr4[j];
                    index++;
                }
            }
            Arrays.sort(sum1);
            Arrays.sort(sum2);
            int ans = Integer.MAX_VALUE;
            int s = 0;
            int e = sum2.length - 1;
            while ( s < sum1.length && e >= 0) {
                int cur = sum1[s] + sum2[e];
                int diff = cur - k;
                if (Math.abs(diff) == Math.abs(ans - k)) {
                    ans = Math.min(ans, cur);
                } else if (Math.abs(diff) < Math.abs(ans - k)) {
                    ans = cur;
                }
                if (cur >= k) {
                    e--;
                } else {
                    s++;
                }
            }
            out.println(ans);
        }
        out.close();
    }

    static class FastScanner {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Integer.parseInt(st.nextToken());
        }

        public int[] readArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}