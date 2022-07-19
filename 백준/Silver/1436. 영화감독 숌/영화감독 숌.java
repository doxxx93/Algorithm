import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 666; true; i++) {
            int tmp = i;
            while (tmp >= 666) {
                if (tmp % 1000 == 666) {
                    count++;
                    break;
                }
                tmp /= 10;
            }
            if (count == n) {
                System.out.println(i);
                break;
            }
        }
    }
}