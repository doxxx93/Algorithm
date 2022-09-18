import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long n = 1;
        while (true) {
            if (n * (n + 1) / 2 > s) {
                System.out.println(n-1);
                break;
            }
            n++;
        }
    }
}