import java.io.*;
import java.util.*;

public class Main {

    static final char[][] ANSWER = {
        {'A', 'B', 'C', 'D'},
        {'E', 'F', 'G', 'H'},
        {'I', 'J', 'K', 'L'},
        {'M', 'N', 'O', '.'}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            var line = br.readLine().toCharArray();
            for (int j = 0; j < 4; j++) {
                if (line[j] == '.') {
                    continue;
                }
                var x = line[j] - 'A';
                ans += Math.abs(i - x / 4) + Math.abs(j - x % 4);
            }
        }
        System.out.println(ans);
    }
}