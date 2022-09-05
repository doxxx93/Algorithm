import java.io.*;
import java.util.*;

class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = {2, 3, 5, 7};
        int[] arr2 = {23, 29, 31, 37, 53, 59, 71, 73, 79};
        int[] arr3 = {233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797};
        int[] arr4 = {2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193,
            7331, 7333, 7393};
        int[] arr5 = {23333, 23339, 23399, 23993, 29399, 31193, 31379, 37337, 37339, 37397, 59393,
            59399, 71933, 73331, 73939};
        int[] arr6 = {233993, 239933, 293999, 373379, 373393, 593933, 593993, 719333, 739391,
            739393, 739397, 739399};
        int[] arr7 = {2339933, 2399333, 2939999, 3733799, 5939333, 7393913, 7393931, 7393933};
        int[] arr8 = {23399339, 29399999, 37337999, 59393339, 73939133};

        sb = new StringBuilder();
        if (n == 1) {
            print(arr1);
        } else if (n == 2) {
            print(arr2);
        } else if (n == 3) {
            print(arr3);
        } else if (n == 4) {
            print(arr4);
        } else if (n == 5) {
            print(arr5);
        } else if (n == 6) {
            print(arr6);
        } else if (n == 7) {
            print(arr7);
        } else if (n == 8) {
            print(arr8);
        }
        System.out.println(sb);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
    }
}
