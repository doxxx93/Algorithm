import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> place = new ArrayList<>();
        while (n > 0) {
            place.add(n % 10);
            n /= 10;
        }
        if (place.size() == 1) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < place.size(); i++) {
            long left = 1;
            long right = 1;
            for (int j = 0; j < i; j++) {
                left *= place.get(j);
            }
            for (int j = i; j < place.size(); j++) {
                right *= place.get(j);
            }
            if (left == right) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
