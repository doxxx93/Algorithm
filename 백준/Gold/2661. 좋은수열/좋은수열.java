import static java.lang.System.exit;

import java.io.*;
import java.util.*;

public class Main {

    static final int S = 1;
    static final int E = 3;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs("");
    }

    private static void dfs(String s) {
        if (s.length() == n) {
            System.out.println(s);
            exit(0);
            return;
        }

        for (int i = S; i <= E; i++) {
            if (isGood(s + i)) {
                dfs(s + i);
            }
        }
    }

    static boolean isGood(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            String a = s.substring(len - i, len);
            String b = s.substring(len - 2 * i, len - i);
            if (a.equals(b)) {
                return false;
            }
        }
        return true;
    }
}
