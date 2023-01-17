import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            int octa = n.charAt(i) - '0';
            String bin = binary[octa];

            if (i == 0) {
                if (bin.startsWith("000")) {
                    sb.append("0");
                } else if (bin.startsWith("00")) {
                    sb.append(bin.charAt(2));
                } else if (bin.startsWith("0")) {
                    sb.append(bin.charAt(1));
                    sb.append(bin.charAt(2));
                } else {
                    sb.append(bin);
                }

            } else {
                sb.append(bin);
            }
        }
        System.out.println(sb);
    }
}
