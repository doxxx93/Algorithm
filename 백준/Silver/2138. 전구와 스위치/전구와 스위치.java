import java.io.*;

public class Main {

    static char source[][], target[];
    static int n, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        source = new char[2][n];
        source[0] = s.toCharArray();
        source[1] = s.toCharArray();
        target = br.readLine().toCharArray();
        answer = Integer.MAX_VALUE;
        //0번째 스위치를 누르지 않고 시작
        go(1, 0, 0);
        //0번째 스위치를 누르고 시작
        push(0, 1);
        go(1, 1, 1);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void push(int index, int type) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < n) {
                source[type][i] = source[type][i] == '0' ? '1' : '0';
            }
        }
    }

    static void go(int index, int count, int type) {
        if (index == n) {
            if (source[type][index - 1] == target[index - 1]) {
                answer = Math.min(answer, count);
            }
            return;
        }
        if (source[type][index - 1] != target[index - 1]) {
            push(index, type);
            go(index + 1, count + 1, type);
        } else {
            go(index + 1, count, type);
        }
    }
}