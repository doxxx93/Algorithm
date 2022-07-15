import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        long tmp = k;
        List<Long> al = new ArrayList<>();

        for (long i = 2; i*i<= k; i++) {
            while (tmp % i == 0) {
                al.add(i);
                tmp /= i;
            }
        }
        if (tmp != 1) {
            al.add(tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (Long l : al) {
            sb.append(l).append(" ");
        }
        System.out.println(al.size());
        System.out.println(sb.toString().trim());
    }
}
