import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        List<Integer> al = new ArrayList<>();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
//            al.add(Integer.parseInt(st.nextToken()));
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        Integer[] arr = al.stream().sorted().toArray(Integer[]::new);
        Arrays.sort(arr);
        
        int target = Integer.parseInt(br.readLine());
        int s = 0;
        int e = n - 1;
        int count = 0;
        while (s < e) {
            if (arr[s] + arr[e] > target) {
                e--;
            } else if (arr[s] + arr[e] < target) {
                s++;
            } else {
                count++;
                s++;
                e--;
            }
        }
        System.out.println(count);
    }
}
