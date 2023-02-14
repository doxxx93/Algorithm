import java.io. *;
import java.util. *;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> al = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt).sorted(Comparator.comparingInt(Math::abs))
            .collect(Collectors.toList());

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = al.get(i);
            int b = al.get(i + 1);
            int sum = a + b;
            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                index = i;
            }
        }
        System.out.println(
            Math.min(al.get(index), al.get(index + 1)) + " " + Math.max(al.get(index),
                al.get(index + 1)));
    }
}