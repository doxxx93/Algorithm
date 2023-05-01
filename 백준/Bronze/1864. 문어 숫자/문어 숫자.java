import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("#")) {
                break;
            }
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                int temp;
                switch (s.charAt(i)) {
                    case '-':
                        temp = 0;
                        break;
                    case '\\':
                        temp = 1;
                        break;
                    case '(':
                        temp = 2;
                        break;
                    case '@':
                        temp = 3;
                        break;
                    case '?':
                        temp = 4;
                        break;
                    case '>':
                        temp = 5;
                        break;
                    case '&':
                        temp = 6;
                        break;
                    case '%':
                        temp = 7;
                        break;
                    case '/':
                        temp = -1;
                        break;
                    default:
                        temp = 0;
                        break;
                }
                sum += temp * Math.pow(8, s.length() - 1 - cnt);
                cnt++;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}