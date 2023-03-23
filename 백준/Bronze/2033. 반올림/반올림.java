import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = 10;
        while (n > p) {
            if (n % p < p / 2) {
                n -= n % p;
            } else {
                n += p - n % p;
            }
            p *= 10;
        }
        System.out.println(n);
    }
}