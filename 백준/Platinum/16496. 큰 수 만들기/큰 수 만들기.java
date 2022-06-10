import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] numbers = new String[T];

        for (int i = 0; i < T; i++) {
            numbers[i] = st.nextToken();
        }

        Arrays.sort(numbers, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (numbers[0].equals("0")) {
            sb.append("0");
        } else {
            for (int i = 0; i < numbers.length; i++) {
                sb.append(numbers[i]);
            }
        }
        System.out.println(sb);
    }
}