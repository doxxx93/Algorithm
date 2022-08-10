import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        long wCount = 0;
        long hCount = 0;
        long eCount = 0;
        long answer = 0;

        for (char c : input) {
            if (c == 'W') {
                wCount++;
            } else if (c == 'H') {
                hCount += wCount;
            } else if (c == 'E') {
                answer = (answer * 2) % 1000000007;
                answer += eCount;
                eCount += hCount;
            }
        }
        System.out.println(answer % 1000000007);
    }
}