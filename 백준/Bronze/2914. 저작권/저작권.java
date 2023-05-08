import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        var a = Integer.parseInt(st.nextToken());
        var i = Integer.parseInt(st.nextToken());
        System.out.println(a * (i - 1) + 1);
    }
}