import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Arrays.fill(arr, K);

        int answer = 0;

        while (true) {
            answer++;
            if (answer % (N/A) == 0) {
                K += B;
            }
            K--;
            if (K == 0) {
                break;
            }
        }
        System.out.println(answer);
    }
}