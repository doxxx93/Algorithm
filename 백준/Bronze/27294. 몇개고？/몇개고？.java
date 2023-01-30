import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");
        final int t = Integer.parseInt(input[0]);
        final int s = Integer.parseInt(input[1]);

        if (t <= 11) {
            System.out.println(280);
            return;
        }
        if (t <= 16) {
            if (s==1) {
                System.out.println(280);
                return;
            }
            System.out.println(320);
            return;
        }
        System.out.println(280);
    }
}