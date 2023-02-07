import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int answer = 1;
        int count = 0;
        while (count < n) {
            int temp = answer;
            // if temp's number is l not count
            while (temp > 0) {
                if (temp % 10 == l) {
                    answer++;
                    break;
                }
                temp /= 10;
            }
            if (temp == 0) {
                count++;
                answer++;
            }
        }
        System.out.println(answer - 1);
    }
}