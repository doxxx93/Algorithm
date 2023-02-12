import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] z) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        StringBuilder[] sbs = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            sbs[i] = new StringBuilder();
        }
        List<String> res = new ArrayList<>();

        for (int i = 1; i < sb.length() - 1; i++) {
            for (int j = i + 1; j < sb.length(); j++) {
                sbs[0].append(sb.substring(0, i));
                sbs[1].append(sb.substring(i, j));
                sbs[2].append(sb.substring(j, sb.length()));
                res.add(sbs[0].reverse().toString() + sbs[1].reverse() + sbs[2].reverse());
                sbs[0].setLength(0);
                sbs[1].setLength(0);
                sbs[2].setLength(0);
            }
        }
        Collections.sort(res);
        System.out.println(res.get(0));
    }
}