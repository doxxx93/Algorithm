import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];
        StringTokenizer st;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (paper[j][k] == 1) {
                        continue;
                    }
                    paper[j][k] = 1;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
