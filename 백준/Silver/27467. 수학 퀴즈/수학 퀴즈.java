import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0) {
                q++;
            } else if (arr[i] % 3 == 1) {
                p++;
            } else {
                p--;
                q--;
            }
        }
        System.out.println(p + " " + q);
    }
}
