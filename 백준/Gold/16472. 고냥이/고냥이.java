import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String st = br.readLine();

        // subString 진짜 구리다
        int length = 1;
        int size = st.length();

        for (int i = 0; i + length <= size; i++) {
            char[] chars = st.substring(i, i + length).toCharArray();
            Set<Character> set = new HashSet<>();
            for (char aChar : chars) {
                set.add(aChar);
            }
            int j = i + length;
            while (j < size) {
                set.add(st.charAt(j));
                if (set.size() > n) {
                    break;
                }
                j++;
                length++;
            }
        }
        System.out.println(length);
    }
}
