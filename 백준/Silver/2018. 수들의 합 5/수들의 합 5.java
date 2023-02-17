import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int s = 1;
        int e = 1;
        int sum = 1;
        while (s <= n) {
            if (sum < n) {
                sum += ++e;
            } else if (sum > n) {
                sum -= s++;
            } else {
                answer++;
                sum += ++e;
            }
        }
        System.out.println(answer);
    }
}