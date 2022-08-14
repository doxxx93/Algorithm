import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int result = 0;
        int move = 0;
        int init = m;

        while (move != N) {
            result++;

            if (m + T <= M) {
                m += T;
                move++;
            } else {
                m -= R;
                if (m < init) {
                    m = init;
                }
            }
            if ((m + T) > M && m == init) {
                break;
            }
        }
        if (move != N) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}