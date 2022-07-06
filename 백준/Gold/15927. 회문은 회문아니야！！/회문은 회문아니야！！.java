import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean flag = false;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                System.out.println(str.length());
                return;
            } else if (str.charAt(i) != str.charAt(i + 1)) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println(str.length() - 1);
        } else {
            System.out.println(-1);
        }
    }
}
