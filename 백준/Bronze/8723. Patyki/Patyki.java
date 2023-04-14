import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        boolean f1 = false, f2 = false;
        if (a[0] == a[1] && a[1] == a[2]) {
            f1 = true;
        }
        if (a[2] * a[2] == a[0] * a[0] + a[1] * a[1]) {
            f2 = true;
        }
        if (!f1 && !f2) {
            System.out.println(0);
        } else if (!f1) {
            System.out.println(1);
        } else if (!f2) {
            System.out.println(2);
        }
    }
}