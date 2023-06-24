import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
        } else if (line.equals("CODE")) {
            System.out.println("MASTER");
        } else if (line.equals("2023")) {
            System.out.println("0611");
        } else {
            System.out.println("CONTEST");
        } 
    }
}
