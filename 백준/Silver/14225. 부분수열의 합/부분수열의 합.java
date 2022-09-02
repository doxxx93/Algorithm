import java.io.*;
import java.util.*;

// 수열 s의 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 구하는 프로그램을 작성하시오.
public class Main {

    static int n;
    static int[] s;
    static boolean[] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[2000001];
        dfs(0, 0);
        for (int i = 1; ; i++) {
            if (!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void dfs(int index, int sum) {
        check[sum] = true;
        if (index == n) {
            return;
        }
        dfs(index + 1, sum + s[index]);
        dfs(index + 1, sum);
    }
}
