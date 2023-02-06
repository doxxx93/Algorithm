import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
        }

        int[] prefix = new int[1002];
        int[] suffix = new int[1002];
        for (int i = 1; i <= 1000; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        for (int i = 1000; i >= 1; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int answer = 0;
        for (int i = 1; i <= 1000; i++) {
            answer += Math.min(prefix[i], suffix[i]);
        }
        System.out.println(answer);
    }
}