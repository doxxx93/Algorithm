import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        long result = 0L;
        for (char c : a) {
            for (char value : b) {
                result += (c - '0') * (value - '0');
            }
        }
        System.out.println(result);
    }
}
