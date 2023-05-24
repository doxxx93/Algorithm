import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println((" @@@   @@@ \n" +
                            "@   @ @   @\n" +
                            "@    @    @\n" +
                            "@         @\n" +
                            " @       @ \n" +
                            "  @     @  \n" +
                            "   @   @   \n" +
                            "    @ @    \n" +
                            "     @     \n").repeat(Integer.parseInt(br.readLine())));
    }
}
