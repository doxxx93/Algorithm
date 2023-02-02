import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = k; i < n + 1; i++) {
            max = Math.max(max, arr[i] - arr[i - k]);
        }
        
        System.out.println(max);
    }
}