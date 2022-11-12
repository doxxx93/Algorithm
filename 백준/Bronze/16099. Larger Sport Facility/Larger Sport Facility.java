import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long l_t = Long.parseLong(st.nextToken());
            long w_t = Long.parseLong(st.nextToken());
            long l_e = Long.parseLong(st.nextToken());
            long w_e = Long.parseLong(st.nextToken());
            if (l_t * w_t > l_e * w_e) {
                System.out.println("TelecomParisTech");
                continue;
            }
            if (l_t * w_t < l_e * w_e) {
                System.out.println("Eurecom");
                continue;
            }
            if (l_t * w_t == l_e * w_e) {
                System.out.println("Tie");
            }
        }
    }
}
