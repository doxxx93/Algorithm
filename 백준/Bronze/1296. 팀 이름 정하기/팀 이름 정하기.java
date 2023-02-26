import java.io.*;

public class Main {

    static final String LOVE = "LOVE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] love = new int[4];
        String name = br.readLine();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == 'L') {
                love[0]++;
            } else if (c == 'O') {
                love[1]++;
            } else if (c == 'V') {
                love[2]++;
            } else if (c == 'E') {
                love[3]++;
            }
        }
        int n = Integer.parseInt(br.readLine());

        int max = -1;
        String maxName = "";

        for (int i = 0; i < n; i++) {
            int[] love2 = new int[4];
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == 'L') {
                    love2[0]++;
                } else if (c == 'O') {
                    love2[1]++;
                } else if (c == 'V') {
                    love2[2]++;
                } else if (c == 'E') {
                    love2[3]++;
                }
            }
            for (int j = 0; j < 4; j++) {
                love2[j] += love[j];
            }
            int total = 1;

            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k++) {
                    total *= love2[j] + love2[k];
                }
            }
            total %= 100;

            if (total > max) {
                max = total;
                maxName = input;
            } else if (total == max) {
                if (input.compareTo(maxName) < 0) {
                    maxName = input;
                }
            }
        }
        System.out.println(maxName);
    }
}