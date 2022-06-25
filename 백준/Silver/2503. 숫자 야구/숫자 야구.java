import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][3];
        int[] strike = new int[n];
        int[] ball = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            data[i][0] = Character.getNumericValue(s.charAt(0));
            data[i][1] = Character.getNumericValue(s.charAt(1));
            data[i][2] = Character.getNumericValue(s.charAt(2));
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (j == k || i == k) {
                        continue;
                    }
                    boolean flag = true;
                    for (int index = 0; index < n; index++) {
                        int[] datum = data[index];
                        int strikeCount = 0;
                        int ballCount = 0;

                        if (datum[0] == i) {
                            strikeCount++;
                        }
                        if (datum[1] == j) {
                            strikeCount++;
                        }
                        if (datum[2] == k) {
                            strikeCount++;
                        }
                        if (datum[0] == j || datum[0] == k) {
                            ballCount++;
                        }
                        if (datum[1] == i || datum[1] == k) {
                            ballCount++;
                        }
                        if (datum[2] == i || datum[2] == j) {
                            ballCount++;
                        }
                        if (strike[index] != strikeCount || ball[index] != ballCount) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
