import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
