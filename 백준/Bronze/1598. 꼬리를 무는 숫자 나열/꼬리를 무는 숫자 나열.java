import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int a = Integer.parseInt(st.nextToken()) - 1;
        final int b = Integer.parseInt(st.nextToken()) - 1;
        final int x1 = a / 4 + 1;
        final int y1 = a % 4 + 1;
        final int x2 = b / 4 + 1;
        final int y2 = b % 4 + 1;
        System.out.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }
}