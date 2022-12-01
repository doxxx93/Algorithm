import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        for (int i = 0; i < n; i++) {
            alphabet[br.readLine().charAt(0) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }
        if (sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }
    }
}
