import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        for(int i = n-1; i > 0; i--) {
            while (arr[i] <= arr[i-1]) {
                arr[i-1]--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}