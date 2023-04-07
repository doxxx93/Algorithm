import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // n's k-th factor
        // 6's 3rd factor is 3
        // if n is 6 and k is 3, then sout 3
        // if n has less than k factors, then sout 0

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count == k) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}