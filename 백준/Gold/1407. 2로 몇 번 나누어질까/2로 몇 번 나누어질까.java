import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long answer = function(B) - function(A - 1);
        System.out.println(answer);

    }

    private static long function(long n) {
        long r = n;
        for (long i = 2; i <= n; i *= 2) {
            r += (n / i) * (i / 2);
        }
        return r;
    }

}