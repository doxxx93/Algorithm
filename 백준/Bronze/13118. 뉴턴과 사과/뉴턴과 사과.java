import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> l = new ArrayList<>();
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            l.add(Long.parseLong(st.nextToken()));
        }
        System.out.println(l.indexOf(Long.parseLong(br.readLine().split(" ")[0])) + 1);
    }
}