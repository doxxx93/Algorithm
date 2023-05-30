import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.equals("1 1 0") || input.equals("0 0 1")) {
            System.out.println("C");
        } else if (input.equals("0 0 0") || input.equals("1 1 1")) {
            System.out.println("*");
        } else if (input.equals("1 0 0") || input.equals("0 1 1")) {
            System.out.println("A");
        } else if (input.equals("1 0 1") || input.equals("0 1 0")) {
            System.out.println("B");
        }
    }
}
