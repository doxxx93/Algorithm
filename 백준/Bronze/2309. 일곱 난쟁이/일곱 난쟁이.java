import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int target = sum - 100;
        int skip1 = 0;
        int skip2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i] + arr[j] == target) {
                    skip1 = i;
                    skip2 = j;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == skip1 || i == skip2) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
