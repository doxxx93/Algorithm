import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
    }
}
