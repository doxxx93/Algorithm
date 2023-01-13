import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                if (a % 2 == 0) {
                    if (n >= a + 2 * b + 2) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
