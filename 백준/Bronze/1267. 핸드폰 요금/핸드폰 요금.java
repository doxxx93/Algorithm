import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] second = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Arrays.setAll(second, i -> Integer.parseInt(st.nextToken()));
        int y = Arrays.stream(second)
            .map(i -> (i / 30 + 1) * 10).sum();
        int m = Arrays.stream(second)
            .map(i -> (i / 60 + 1) * 15).sum();
        if (y == m) {
            System.out.println("Y M " + y);
            return;
        }
        if (y > m) {
            System.out.println("M " + m);
            return;
        }
        System.out.println("Y " + y);
    }
}
