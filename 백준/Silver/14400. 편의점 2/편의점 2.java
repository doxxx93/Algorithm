import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(xs);
        Arrays.sort(ys);
        int x = xs[n / 2];
        int y = ys[n / 2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long)Math.abs(x - xs[i]) + (long)Math.abs(y - ys[i]);
        }
        System.out.println(sum);
    }
}
