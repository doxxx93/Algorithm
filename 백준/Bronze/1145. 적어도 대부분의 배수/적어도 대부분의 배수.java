import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int n = arr[0];
        int count = 1;
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (n >= arr[i] && n % arr[i] == 0) {
                    count++;
                }
            }
            if (count > 2) {
                break;
            }
            n++;
            count = 0;
        }
        System.out.println(n);
    }
}
