import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                count++;
            } else {
                count++;
                i++;
            }
        }
        System.out.println(Math.min(count, n));
    }
}