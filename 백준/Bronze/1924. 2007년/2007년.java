import java.io. *;
import java.util. *;

public class Main {
    // 2007년 x월 y일의 요일 구하기
    static final int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
    static final String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i=0; i<x-1; i++) {
            sum += month[i];
        }
        sum += y;
        System.out.println(day[sum%7]);
    }
}