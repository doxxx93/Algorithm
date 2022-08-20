import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        Arrays.setAll(arr, i -> Integer.parseInt(st.nextToken()));
        Arrays.sort(arr);
        long answer = arr[0] * arr[n - 1];
        System.out.println(answer);
    }
}