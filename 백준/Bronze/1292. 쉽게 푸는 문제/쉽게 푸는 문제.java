import java.io. *;
import java.util. *;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
//        List<Integer> al = IntStream.rangeClosed(1, 45)
//                .boxed()
//                .flatMap(i -> IntStream.rangeClosed(1, i).mapToObj(j -> i))
//                .collect(Collectors.toList());
//        int sum = al.subList(a - 1, b).stream().mapToInt(Integer::intValue).sum();
        // refactor above
        int sum = IntStream.rangeClosed(1, 45)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(1, i).mapToObj(j -> i))
                .skip(a - 1)
                .limit(b - a + 1)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }
}
