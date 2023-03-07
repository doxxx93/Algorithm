import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        ArrayList<Boolean> sec = new ArrayList<Boolean>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {    //음악 n초 출력
                sec.add(true);
            }

            if (i != n - 1) { // 마지막 곡이 아닐 경우
                for (int j = 0; j < 5; j++) {    // 음악과 음악 사이 5초
                    sec.add(false);
                }
            }
        }

        int result = 0;
        while (result < sec.size()) {
            if (!sec.get(result)) {
                break;
            }
            result += d;
        }
        System.out.println(result);
    }
}