import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] unit = {25, 10, 5, 1};
        while (t-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int[] ans = new int[4];
            for (int i = 0; i < 4; i++) {
                ans[i] = c / unit[i];
                c %= unit[i];
            }
            for (int i = 0; i < 4; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

}