import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line1 = new int[26];
        int[] line2 = new int[26];
        String s1 = br.readLine();
        String s2 = br.readLine();
        for (int i = 0; i < s1.length(); i++) {
            line1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            line2[s2.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(line1[i] - line2[i]);
        }
        System.out.println(sum);
    }
}
