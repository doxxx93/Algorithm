import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] number = new boolean[1234567];
        for (int i = 1; i <= 10000; i++) {
            int n = d(i);
            number[n] = true;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!number[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}