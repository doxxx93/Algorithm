import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (k == 0 || k == 1) {
                continue;
            }
            System.out.println("F");
            return;
        }
        System.out.println("S");
    }
}
