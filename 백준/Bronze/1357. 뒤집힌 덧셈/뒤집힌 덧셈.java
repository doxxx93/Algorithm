import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(rev(rev(x) + rev(y)));
    }

    private static int rev(int x) {
        int temp = 0;
        while (x > 0) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return temp;
    }
}
