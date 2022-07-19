import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        for (long i = 2; i * i <= n; i++) {
            long j = n / i;
            answer += (i + j) * (j - i + 1) / 2;
            answer += i * (j - i);
        }
        System.out.println(answer % 1000000);
    }
}