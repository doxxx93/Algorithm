import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= i; j++) {
                if (i * i - j * j == n) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}