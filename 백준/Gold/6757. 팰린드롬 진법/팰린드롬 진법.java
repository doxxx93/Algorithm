import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int base = 2; base * base < x; base++) {
            list = new ArrayList<>();
            int temp = x;
            while (temp > 0) {
                list.add(temp % base);
                temp /= base;
            }
            if (isPalindrome(list)) {
                sb.append(base).append("\n");
            }
        }
        int k = (int) Math.ceil(Math.sqrt(x));
        for (; k >= 1; k--) {
            if (((double) x) / k == x / k && x / k - 1 > k) {
                sb.append(x / k - 1).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isPalindrome(List<Integer> list) {
        for (int i = 0; i < list.size() / 2 + 1; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
