import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        System.out.println((8 * r + 3 * s) - 28);
    }
}
