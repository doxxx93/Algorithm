import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(br.readLine()));
        }
        if (al.get(2) - al.get(1) == al.get(1) - al.get(0)) {
            System.out.println(al.get(n - 1) + al.get(1) - al.get(0));
        } else {
            System.out.println(al.get(n - 1) * (al.get(1) / al.get(0)));
        }
    }
}
