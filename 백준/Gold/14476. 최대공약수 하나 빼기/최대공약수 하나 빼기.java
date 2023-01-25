import java.io.*;
import java.util.*;

/**
 * 한개를 뺐을 때의 최대공약수
 * 완탐: 1개씩 뻇을 때 모든 경우의 수 살피기
 *
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] lgcd = new int[n + 2];
        int[] rgcd = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            lgcd[i] = gcd(lgcd[i - 1], arr[i]);
        }
        for (int i = n; i >= 1; i--) {
            rgcd[i] = gcd(rgcd[i + 1], arr[i]);
        }

        int index = -1;
        int max = -1;
        for (int i = 1; i <= n; i++) {
            int gcd = gcd(lgcd[i - 1], rgcd[i + 1]);
            if (max < gcd) {
                if (arr[i] % gcd != 0) {
                    max = gcd;
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println(-1);
        } else {
            System.out.println(max + " " + arr[index]);
        }
    }

    private static int gcd(int i, int j) {
        if (j == 0) {
            return i;
        }
        return gcd(j, i % j);
    }
}
