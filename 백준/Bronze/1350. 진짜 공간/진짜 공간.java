import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int c = Integer.parseInt(br.readLine());
        long count = 0;
        for (long i : arr) {
            if (i % c == 0) {
                count += i / c;
            } else {
                count += i / c + 1;
            }
        }
        System.out.println(count * c);
    }
}
