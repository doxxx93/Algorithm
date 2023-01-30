import java.io.*;
import java.util.*;

/**
 * 양수 부, 음수 부를 나누어서
 * 절대값이 큰 값부터 m개씩 묶어서 절대값이 큰 값이 경로가 된다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int n = Integer.parseInt(input[0]);
        final int m = Integer.parseInt(input[1]);

        int[] books = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        Arrays.sort(books);

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        int max = 0;

        for (int book : books) {
            if (book > 0) {
                max = Math.max(book, max);
                positive.add(book);
            } else {
                max = Math.max(-book, max);
                negative.add(-book);
            }
        }

        int sum = 0;
        for (int i = positive.size() - 1; i >= 0; i -= m) {
            sum += positive.get(i) * 2;
        }
        for (int i = 0; i < negative.size(); i += m) {
            sum += negative.get(i) *2;
        }
        System.out.println(sum - max);
    }
}