import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        System.out.println(sb);
    }
}
