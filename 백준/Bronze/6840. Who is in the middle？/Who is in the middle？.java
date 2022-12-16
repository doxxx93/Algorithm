import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            al.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(al);
        System.out.println(al.get(1));
    }
}
