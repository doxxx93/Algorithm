import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        int[][] homework = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            homework[i][0] = Integer.parseInt(st.nextToken());
            homework[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homework, (o1, o2) -> o2[1] - o1[1]);

        int startDay = homework[0][1];
        for (int i = 0; i < n - 1; i++) {
            if (startDay - homework[i][0] > homework[i + 1][1]) {
                startDay = homework[i + 1][1];
            } else {
                startDay -= homework[i][0];
            }
        }

        answer = Math.max(answer, startDay - homework[n - 1][0]);
        System.out.println(answer);
    }
}