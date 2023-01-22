import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        // x 는 1부터 n까지 a의 배수의 개수를 의미한다.
        int x = n / a;
        int ans = x;
        while (x >= a) {
            x /= a;
            ans += x;
        }
        System.out.println(ans);
    }
}
