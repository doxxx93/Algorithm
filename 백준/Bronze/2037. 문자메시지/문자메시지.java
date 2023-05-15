import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        char[][] group = {{'A', 'C'}, {'D', 'F'}, {'G', 'I'}, {'J', 'L'}, {'M', 'O'}, {'P', 'S'},
            {'T', 'V'}, {'W', 'Z'}};

        int before = -1;
        int cnt = 0;
        boolean flag = false;
        int ret = 0;

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);

            if (Character.isLetter(temp)) {
                for (int j = 0; j < 8; j++) {
                    if (temp >= group[j][0] && temp <= group[j][1]) {
                        if (before == j) {
                            flag = true;
                        }

                        cnt = (temp - group[j][0] + 1) * p;
                        before = j;
                    }
                }
            } else {
                cnt = p;
                before = -1;
            }

            if (flag) {
                cnt += w;
            }
            ret += cnt;

            flag = false;
        }

        System.out.println(ret);
    }
}
