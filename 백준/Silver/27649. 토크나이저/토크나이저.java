import java.io.*;
import java.util.*;

public class Main {

    //    public static final String[] DELIMITERS = {"<", ">", "&&", "||", "(", ")"};
    public static final String DELIMITERS = "<>&&||() ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), DELIMITERS, true);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals(" ")) {
                continue;
            } else if (s.equals("&")) {
                st.nextToken();
                sb.append("&&");
            } else if (s.equals("|")) {
                st.nextToken();
                sb.append("||");
            } else {
                sb.append(s);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}