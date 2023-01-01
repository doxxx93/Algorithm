import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(
            (IntStream.range(0, n).boxed().flatMap(i -> IntStream.range(i + 1, n).boxed().flatMap(
                    j -> IntStream.range(j + 1, n).boxed()
                        .map(k -> Math.abs(x[i] * y[j] + x[j] * y[k] + x[k] * y[i]
                                           - x[j] * y[i] - x[k] * y[j] - x[i] * y[k]))))
                 .mapToDouble(Double::valueOf).max().getAsDouble() / 2));
    }
}
