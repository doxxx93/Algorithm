import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        Arrays.sort(s, Collections.reverseOrder());
        System.out.println(Arrays.toString(s).replaceAll("[\\[\\], ]", ""));
    }
}