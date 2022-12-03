import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        String line;
        while (!(line = br.readLine()).equals("END")) {
            sb = new StringBuilder(line);
            sb.reverse();
            System.out.println(sb);
        }
    }
}
