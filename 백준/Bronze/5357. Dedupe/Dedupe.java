import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            Stack<Character> q = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if (!q.isEmpty() && q.peek() == s.charAt(j)) {
                    continue;
                }
                q.add(s.charAt(j));
            }
            while (!q.isEmpty()) {
                sb.append(q.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}