import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int tmp = lcm / gcd;
        int a = 0, b = 0;
        for (int i = (int) Math.sqrt(tmp); i >= 1; i--) {
            if (tmp % i == 0 && gcd(i, tmp / i) == 1) {
                a = i * gcd;
                b = tmp / i * gcd;
                break;
            }
        }
        System.out.println(a + " " + b);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
