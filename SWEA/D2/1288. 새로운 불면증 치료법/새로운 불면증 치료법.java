import java.io.*;

class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
        Long T = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (long test_case = 1; test_case <= T; test_case++) {
            long n = Long.parseLong(br.readLine());
            long con = n;
            int check = 0;
            while (true) {
                long temp = n;
                while (temp > 0) {
                    check |= 1 << (temp % 10);
                    temp /= 10;
                }
                if (check == 1023) {
                    break;
                }
                n += con;
            }
            sb.append("#").append(test_case).append(" ").append(n).append("\n");
        }
        System.out.println(sb);
    }
}
