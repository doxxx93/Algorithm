import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int zr = Integer.parseInt(st.nextToken()), zc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < zr; j++) {
                for (int k = 0; k < c; k++) {
                    for (int l = 0; l < zc; l++) {
                        System.out.print(s.charAt(k));
                    }
                }
                System.out.println();
            }
        }
    }
}
