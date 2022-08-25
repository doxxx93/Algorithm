import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int num = n;
        int newNum = 0;
        int a = 0;
        int b = 0;

        while (true) {
            a = num / 10;
            b = num % 10;
            newNum = b * 10 + (a + b) % 10;
            count++;
            if (newNum == n) {
                break;
            }
            num = newNum;
        }
        System.out.println(count);
    }
}
