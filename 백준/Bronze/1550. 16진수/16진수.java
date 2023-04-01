import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String y = br.readLine();
        int yChar;
        long sum = 0;
        int tenMultiply;
        for (int i = 0; i < y.length(); i++) {
            yChar = y.charAt(i);
            tenMultiply = 1;

            for (int j = y.length() - 1; j > i; j--) {
                tenMultiply *= 16;
            }

            if (48 < yChar && yChar < 58) {
                sum += (long) (yChar - 48) * tenMultiply;
            } else if (64 < yChar && yChar < 71) {
                sum += (long) (yChar - 55) * tenMultiply;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}