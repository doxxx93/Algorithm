import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        int index1 = 0;
        int index2 = 0;
        Loop1:
        for (int i = 0; i < 9; i++) {
            Loop2:
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] + arr[j] == sum - 100) {
                    index1 = i;
                    index2 = j;
                    break Loop1;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == index1 || i == index2) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}