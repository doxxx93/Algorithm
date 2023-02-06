import java.io.*;
import java.util.*;

public class Main {

    private final static int PLUS = (int) 5e5;
    private final static int NN = (int) 1e5;
    private final static int MAX = (int) 1e6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[NN + 1];
        int[] y = new int[NN + 1];
        int[] xCount = new int[MAX + 1];
        int[] yCount = new int[MAX + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken()) + PLUS;
            y[i] = Integer.parseInt(st.nextToken()) + PLUS;
        }
        x[n] = x[0];
        y[n] = y[0];

        for (int i = 0; i < n; i++) {
            if (x[i] == x[i + 1]) {
                if (y[i] < y[i + 1]) {
                    yCount[y[i]]++;
                    yCount[y[i + 1]]--;
                    continue;
                }
                yCount[y[i + 1]]++;
                yCount[y[i]]--;
                continue;
            }
            if (x[i] < x[i + 1]) {
                xCount[x[i]]++;
                xCount[x[i + 1]]--;
                continue;
            }
            xCount[x[i + 1]]++;
            xCount[x[i]]--;
        }

        int ans = 0;
        for (int i = 1; i <MAX; i++) {
            xCount[i] += xCount[i - 1];
            yCount[i] += yCount[i - 1];
            ans = Math.max(ans, Math.max(xCount[i], yCount[i]));
        }

        System.out.println(ans);
    }
}