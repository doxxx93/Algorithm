import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] scores = new int[2][5];
        int[] mul = {6, 3, 2, 1, 2};
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] sum = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                sum[i] += scores[i][j] * mul[j];
            }
        }
        System.out.println(sum[0] +" "+ sum[1]);
    }
}
