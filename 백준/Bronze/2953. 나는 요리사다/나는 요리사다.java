import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sums = new int[5];

        int max = 0;
        int maxIdx = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                sums[i] += scan.nextInt();
            }
            if (sums[i] > max) {
                max = sums[i];
                maxIdx = i + 1;
            }
            
        }
        System.out.print(maxIdx + " ");
        System.out.println(max);


    }
}
