import java.io.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        int N = 41;
        int[] primeNumbers = IntStream.rangeClosed(2, N).filter(Main::isPrime).toArray();

        int left = 0, right = 0;
        int count = 0;
        int sum = 0;
        while (true) {
            if (sum >= N) {
                sum -= primeNumbers[left++];
            } else if (right == primeNumbers.length) {
                break;
            } else {
                sum += primeNumbers[right++];
            }
            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int candidate) {
        if (candidate == 2) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(candidate); i++) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }
}