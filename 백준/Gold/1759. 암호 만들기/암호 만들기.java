import java.io.*;
import java.util.*;

class Main {

    static int l;
    static int c;
    static char[] arr;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        dfs(0, 0, 0, 0);

    }

    private static void dfs(int depth, int vowel, int consonant, int start) {
        if (depth == l) {
            if (vowel >= 1 && consonant >= 2) {
                System.out.println(sb);
            }
            return;
        }
        for (int i = start; i < c; i++) {
            sb.append(arr[i]);
            if (isVowels(arr[i])) {
                dfs(depth + 1, vowel + 1, consonant, i + 1);
            } else {
                dfs(depth + 1, vowel, consonant + 1, i + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
