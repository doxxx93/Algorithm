import java.io. *;
import java.math.*;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int n = 0;

        for (int i = 2; i < l; i++) {
            if(k.remainder(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO)==0) {
                n = i;
                break;
            }
        }
        if (n > 0) {
            System.out.println("BAD " + n);
        } else {
            System.out.println("GOOD");
        }
    }
}
