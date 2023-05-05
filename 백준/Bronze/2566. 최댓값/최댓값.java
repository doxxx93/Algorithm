import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ans = new int[3];
        ans[0] = -1;
        StringTokenizer st;
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(ans[0] < num) {
                    ans[0] = num;
                    ans[1] = i;
                    ans[2] = j;
                }
            }
        }
        System.out.println(ans[0]);
        System.out.println(ans[1] + " " + ans[2]);
    }
}