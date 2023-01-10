import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            for (int i = 1; i <= n; i++) {
                sb.append("*".repeat(Math.max(0, i))).append("\n");
            }
        }
        System.out.println(sb);
    }
}
