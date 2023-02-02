import java.io.*;
import java.util.*;

/**
 * K의 개수가 S의 개수의 2배라면, S는 2, K는 -1로 간주하여 구간 합이 0이되는 부분이 SKK 문자열이다.
 * 구간합 i ~ j가 0이 되는 것을 식으로 표현하면, prefixSum[j] - prefixSum[i-1] = 0 과 같다.
 * prefixSum[j] = prefixSum[i-1] 이므로, prefixSum[i-1]이 이미 나왔던 값이라면, i ~ j 구간은 SKK 문자열이다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String input = br.readLine();
        final int length = input.length();
        int[] index = new int[length * 3 + 1];
        int[] prefixSum = new int[length + 1];
        int[] kCount = new int[length + 1];
        int[] sCount = new int[length + 1];
        Arrays.fill(index, Integer.MAX_VALUE);
        for (int i = 1; i <= length; i++) {
            prefixSum[i] = prefixSum[i - 1];
            kCount[i] = kCount[i - 1];
            sCount[i] = sCount[i - 1];
            if (input.charAt(i - 1) == 'S') {
                prefixSum[i] += 2;
                sCount[i]++;
            }
            if (input.charAt(i - 1) == 'K') {
                prefixSum[i] -= 1;
                kCount[i]++;
            }
        }
        int answer = -1;

        for (int i = 0; i <= length; i++) {
            index[prefixSum[i] + length] = Math.min(index[prefixSum[i] + length], i);
        }

        for (int i = 1; i <= length; i++) {
            int left = index[prefixSum[i] + length];
            int skkLength = i - left;
//            int k = kCount[i] - kCount[left];
//            int s = sCount[i] - sCount[left];
            if (kCount[i] != kCount[left]) {
                answer = Math.max(answer, skkLength);
            }
        }
        System.out.println(answer);
    }
}