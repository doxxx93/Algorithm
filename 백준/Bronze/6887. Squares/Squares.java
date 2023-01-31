import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 1; i * i <= n; i++) {
            max++;
        }
        System.out.printf("The largest square has side length %d.", max);
    }
}