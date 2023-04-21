import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long sum = n;
        for (int i = 0; i < n; i++) {
            arr[i] -= b;
            if (arr[i] > 0) {
                sum += arr[i] / c;
                if (arr[i] % c != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}