import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char prev = a[a.length - 1];
        int load = 0;
        int load2 = 0;
        for (char i : a) {
            if (i == '1') {
                load++;
                if (prev == '1') {
                    load2++;
                }
            }
            prev = i;
        }
        int z = load2 * a.length - load * load;
        System.out.println(z == 0 ? "EQUAL" : z < 0 ? "ROTATE" : "SHOOT");
    }
}