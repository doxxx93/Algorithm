import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        int[] hi = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        int[] ai = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ai[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ai);
        for (int i = 0; i < n; i++) {
            sum += ai[i] * i;
        }
        System.out.println(sum);
    }
}