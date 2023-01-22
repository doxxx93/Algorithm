import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int length = input.length();

        char[][] arr = new char[length / k][k];
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k; j++) {
                if (i % 2 == 0) {
                    arr[i][j] = input.charAt(i * k + j);
                } else {
                    arr[i][j] = input.charAt(i * k + (k - j - 1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < length / k; i++) {
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);
    }
}
