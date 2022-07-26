import java.io.*;
import java.util.*;

public class Main {

    static int[] a;
    static int[] b;
    static int diff;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        diff = 0;
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (b[i] != a[i]) {
                diff++;
            }
        }
        if (diff == 0) {
            System.out.println(1);
            return;
        }
        sb = new StringBuilder();
        select(a, 0, n - 1, q);
        if (sb.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

    private static int select(int[] a, int start, int end, int q) {
        if (start == end) {
            return a[start];
        }
        int t = partition(a, start, end);
        int k = t - start + 1;
        if (q < k) {
            return select(a, start, t - 1, q);
        } else if (q == k) {
            return a[t];
        } else {
            return select(a, t + 1, end, q - k);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        if (i + 1 != end) {
            swap(a, i + 1, end);
        }
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        if (a[i] == b[i]) {
            diff++;
        }
        if (a[j] == b[j]) {
            diff++;
        }
        if (a[i]== b[j]) {
            diff--;
        }
        if (a[j] == b[i]) {
            diff--;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        if (diff == 0) {
            sb.append(1);
        }
    }
}