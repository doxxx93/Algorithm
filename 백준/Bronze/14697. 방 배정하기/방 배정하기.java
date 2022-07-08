import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if (a == 1) {
            System.out.println(1);
            return;
        }
        if (c % a == 0 && b % a == 0) {
            if (n % a == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                for (int k = 0; k <= 50; k++) {
                    int sum = i * c + j * b + k * a;
                    if (sum == n) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
