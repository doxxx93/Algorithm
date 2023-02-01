import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] prefix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + num;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = i; k <= n; k++) {
                    for (int l = j; l <= m; l++) {
                        int sum = prefix[k][l] - prefix[i - 1][l] - prefix[k][j - 1] + prefix[i - 1][j - 1];
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        System.out.println(max);
    }
}