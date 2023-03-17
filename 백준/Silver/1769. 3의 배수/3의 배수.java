import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int count = 0;
        while (number.length() > 1) {
            int sum = 0;
            for (int i = 0; i < number.length(); i++) {
                sum += number.charAt(i) - '0';
            }
            number = Integer.toString(sum);
            count++;
        }
        System.out.println(count);
        System.out.println(Integer.parseInt(number) % 3 == 0 ? "YES" : "NO");
    }
}