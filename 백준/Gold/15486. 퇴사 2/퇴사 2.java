import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] consults = new int[n + 2][2];
        int[] profit = new int[n + 2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            consults[i][0] = Integer.parseInt(st.nextToken());
            consults[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, profit[i]);
            if (i + consults[i][0] > n + 1) {
                continue;
            }
            profit[i + consults[i][0]] = Math.max(profit[i + consults[i][0]], max + consults[i][1]);
        }
        System.out.println(max);
    }
}
