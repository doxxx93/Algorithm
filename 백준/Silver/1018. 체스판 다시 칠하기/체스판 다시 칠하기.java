import java.io. *;
import java.util. *;

public class Main {

    enum Color {
        W('W',0), B('B',1);
        char aChar;
        int value;

        Color(char aChar, int value) {
            this.aChar = aChar;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) == 'W' ? Color.W.getValue() : Color.B.getValue();
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int cnt = 0;
                int start = arr[i][j];
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (arr[k][l] != start) {
                            cnt++;
                        }
                        start = (start + 1) % 2;
                    }
                    start = (start + 1) % 2;
                }
                min = Math.min(min, cnt);
                cnt = 0;
                start = (arr[i][j] + 1) % 2;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (arr[k][l] != start) {
                            cnt++;
                        }
                        start = (start + 1) % 2;
                    }
                    start = (start + 1) % 2;
                }
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }
}