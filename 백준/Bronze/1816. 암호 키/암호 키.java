import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            long s = Long.parseLong(br.readLine());
            boolean go = true;
            for (long i = 2; i < 1000000; i++) {
                if (s % i == 0) {
                    go = false;
                    break;
                }
            }
            if (go) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }
}
