import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cSum = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());
            cSum[i] = sum;
        }
        if (cSum[9] <= 100) {
            System.out.println(cSum[9]);
            return;
        }
        int index = 0;
        for (int i = 0; i < cSum.length; i++) {
            if (cSum[i] >= 100) {
                index = i;
                break;
            }
        }


        if (index == 0) {
            System.out.println(cSum[index]);
        } else {
            if (cSum[index] - 100 <= 100 - cSum[index - 1]) {
                System.out.println(cSum[index]);
            } else {
                System.out.println(cSum[index - 1]);
            }
        }

    }
}
