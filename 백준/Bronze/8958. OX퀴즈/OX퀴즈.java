import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();

            int count = 0;
            int score = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') {
                    count++;
                    score += count;
                } else {
                    count = 0;
                }

            }
            System.out.println(score);
        }
    }
}