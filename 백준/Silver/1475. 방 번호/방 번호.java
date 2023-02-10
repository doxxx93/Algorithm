import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[10];
        while (n > 0) {
            numbers[n % 10]++;
            n /= 10;
        }
        numbers[6] = (numbers[6] + numbers[9] + 1) / 2;
        numbers[9] = 0;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println(max);
    }
}