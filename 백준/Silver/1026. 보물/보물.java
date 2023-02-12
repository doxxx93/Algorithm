import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * b[n - i - 1];
        }
        System.out.println(sum);
    }
}