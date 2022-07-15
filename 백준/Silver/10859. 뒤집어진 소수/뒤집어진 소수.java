import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n == 1) {
            System.out.println("no");
            return;
        }
        if (n == 2) {
            System.out.println("yes");
            return;
        }
        long tmp = n;
        List<Integer> list = new ArrayList<>();
        while (tmp > 0) {
            int x = (int) (tmp % 10);
            if (x == 3 || x == 4 || x == 7) {
                System.out.println("no");
                return;
            }
            list.add(x);
            tmp /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Integer x = list.get(i);
            if (x == 1) {
                sb.append(1);
            } else if (x == 2 || x == 5 || x == 8 || x == 0) {
                sb.append(x);
            } else if (x == 6) {
                sb.append(9);
            } else if (x == 9) {
                sb.append(6);
            }
        }
        if (isPrime(Long.parseLong(sb.toString()))&&isPrime(n)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean isPrime(long candidate) {
        for (long i = 2; i * i <= candidate; i++) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }
}