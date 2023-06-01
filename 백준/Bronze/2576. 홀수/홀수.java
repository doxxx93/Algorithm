import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 2 == 1) {
                list.add(x);
            }
        }
        Collections.sort(list);
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(list.stream().mapToInt(Integer::intValue).sum());
            System.out.println(list.get(0));
        }
    }
}
