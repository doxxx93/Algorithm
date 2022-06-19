import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayInWeek = {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
        String answer = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < month - 1; i++) {
            result += daysInMonth[i];
        }
        answer = dayInWeek[(day + result) % 7];
        System.out.println(answer);
    }
}