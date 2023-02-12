import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int six = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            six = Math.min(six, Integer.parseInt(st.nextToken()));
            one = Math.min(one, Integer.parseInt(st.nextToken()));
        }
        int q = n / 6;
        int r = n % 6;
        if (six > one * 6) {
            System.out.println(one * n);
        } else {
            System.out.println(six * q + Math.min(six, one * r));
        }
    }
}