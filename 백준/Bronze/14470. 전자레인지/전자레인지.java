import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int sum = 0;
        if (a < 0) {
            sum += -a * c;
            sum += d;
            a = 0;
        }
        sum += (b - a) * e;
        System.out.println(sum);
    }
}