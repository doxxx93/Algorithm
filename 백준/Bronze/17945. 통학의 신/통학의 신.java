import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = -(int) Math.sqrt(1000); i * i <= 1000; i++) {
            if (i * i + 2 * a * i + b == 0) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
