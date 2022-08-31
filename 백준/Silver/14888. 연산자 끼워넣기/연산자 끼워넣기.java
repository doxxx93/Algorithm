import java.io.*;
import java.util.*;

public class Main {

    static int max;
    static int min;
    static int[] operator = new int[4];
    static int[] number;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[n];

        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(1, number[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int index, int result) {
        if (index == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                if (i == 0) {
                    dfs(index + 1, result + number[index]);
                } else if (i == 1) {
                    dfs(index + 1, result - number[index]);
                } else if (i == 2) {
                    dfs(index + 1, result * number[index]);
                } else if (i == 3) {
                    dfs(index + 1, result / number[index]);
                }
                operator[i]++;
            }
        }
    }
}
