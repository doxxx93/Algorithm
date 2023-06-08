import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        // 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬으로 만든다. name length <= 50
        // 불가능한 경우 I'm Sorry Hansoo를 출력한다.
        // 가능한 경우 사전순으로 가장 빠른 답을 출력한다.
        // code
        int[] alphabet = new int[26];
        for (int i = 0; i < name.length(); i++) {
            alphabet[name.charAt(i) - 'A']++;
        }
        int odd = 0;
        int oddIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 == 1) {
                odd++;
                oddIndex = i;
            }
        }
        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(String.valueOf((char) (i + 'A')).repeat(Math.max(0, alphabet[i] / 2)));
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        if (oddIndex != -1) {
            sb.append((char) (oddIndex + 'A'));
        }
        sb.append(reverse);
        System.out.println(sb.toString());
    }
}
