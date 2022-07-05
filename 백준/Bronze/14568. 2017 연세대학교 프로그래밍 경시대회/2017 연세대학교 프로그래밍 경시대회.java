import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int t = 2; t < n; t += 2) {
            for (int y = 1; y < n; y++) {
                for (int i = y + 2; i < n; i++) {
                    if (i + y + t == n) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
