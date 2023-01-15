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

        int count = 0;
        for (int i = 0; i < n / c; i++) {
            for (int j = 0; j < n / b; j++) {
                for (int k = 0; k < n / a; k++) {
                    if (i * c + j * b + k * a == n) {
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
