import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            sum = Math.max(sum, Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum());
        }
        System.out.println(sum);
    }
}
