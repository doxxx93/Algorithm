import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // number to roman n <= 10000
        /*
        Робинзон Крузо на необитаемом острове отмечает дни стене своей хижины.

        Каждый день он ставит зарубку, которую будем обозначать английской буквой <<I>>, а раз в 5 дней зачеркивает четыре предыдущие зарубки, получая символ, который мы обозначим как <<V>>.

        Какая запись получится на стене хижины Робинзона на $n$-й день?
         */
        int n = Integer.parseInt(br.readLine());
        int v = n / 5;
        int i = n % 5;
        StringBuilder sb = new StringBuilder();
        sb.append("V".repeat(Math.max(0, v)));
        sb.append("I".repeat(Math.max(0, i)));
        System.out.println(sb.toString());
    }
}
