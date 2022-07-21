import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> al = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(al, Comparator.comparingInt(Math::abs));

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < al.size() - 1; i++) {
            int diff = al.get(i) + al.get(i + 1);
            min = Math.abs(diff) > Math.abs(min) ? min : diff;
            index = Math.abs(diff) > Math.abs(min) ? index : i;
        }
        if (al.get(index) < al.get(index + 1)) {
            System.out.println(al.get(index) + " " + al.get(index + 1));
        } else {
            System.out.println(al.get(index + 1) + " " + al.get(index));
        }
    }
}
