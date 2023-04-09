import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int leftCount = 0;
        int rightCount = 0;
        // when you see the arr in the left, leftCount is how many pillars that you can see
        // when you see the arr in the right, rightCount is how many pillars that you can see
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > leftMax) {
                leftMax = arr[i];
                leftCount++;
            }
            if(arr[n - i - 1] > rightMax) {
                rightMax = arr[n - i - 1];
                rightCount++;
            }
        }
        System.out.println(leftCount + "\n" + rightCount);
    }
}