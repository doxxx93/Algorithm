import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[42];
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine()) % 42;
            arr[x]++;
        }
        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}