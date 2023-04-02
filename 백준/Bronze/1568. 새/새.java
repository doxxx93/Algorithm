import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time = 0;
        int sum = 0;
        while (true) {
            sum++;
            if (n < sum) {
                sum = 1;
            }
            n-= sum;
            time++;

            if (n <= 0) {
                System.out.println(time);
                break;
            }
        }
    }
}