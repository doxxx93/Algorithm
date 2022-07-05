import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int count = 0;
        int sheep = 0;
        for (int i = 1; i <= n - 1; i++) {
            if (a * i + b * (n - i) == w) {
                sheep = i;
                count++;
            }
        }
        if (count == 1) {
            System.out.println(sheep + " " + (n - sheep));
        } else {
            System.out.println(-1);
        }
    }
}
