import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(LIS(arr));
    }

    private static int upperBound(int[] ar, int l, int r, int key) {
        while (l < r - 1) {
            int m = (l + r) >>> 1;
            if (ar[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }

    private static int LIS(int[] array) {
        int N = array.length;
        if (N == 0) {
            return 0;
        }

        int[] tail = new int[N];

        // always points empty slot in tail
        int length = 1;

        tail[0] = array[0];
        for (int i = 1; i < N; i++) {
            // new smallest value
            if (array[i] < tail[0]) {
                tail[0] = array[i];
            } // array[i] extends largest subsequence
            else if (array[i] > tail[length - 1]) {
                tail[length++] = array[i];
            } // array[i] will become end candidate of an existing subsequence or
            // Throw away larger elements in all LIS, to make room for upcoming grater elements than
            // array[i]
            // (and also, array[i] would have already appeared in one of LIS, identify the location and
            // replace it)
            else {
                tail[upperBound(tail, -1, length - 1, array[i])] = array[i];
            }
        }

        return length;
    }
}