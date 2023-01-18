import java.util.*;
import java.util.stream.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        /**
         * 명령어
         * I: x, y, s
         * x위치 다음에 y개의 숫자를 삽입, s는 삽입할 숫자들
         * D: x, y
         * x위치 다음에 y개의 숫자를 삭제
         * A: y, s
         * 맨 뒤에 y개의 숫자를 삽입, s는 삽입할 숫자들
         * 수정된 결과의 처음 10개를 출력
         */
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split(" ");
            List<String> list = new ArrayList<>(Arrays.asList(input));
            int m = Integer.parseInt(sc.nextLine());

            for (int k = 0; k < m; k++) {
                String command = sc.next();
                if (command.equals("I")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int i = 1; i <= y; i++) {
                        list.add(x, sc.next());
                        x++;
                    }
                } else if (command.equals("D")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int i = 1; i <= y; i++) {
                        list.remove(x);
                    }
                } else if (command.equals("A")) {
                    int y = sc.nextInt();
                    for (int i = 1; i <= y; i++) {
                        list.add(sc.next());
                    }
                } else {
                    break;
                }
            }
            sc.nextLine();

            sb.append("#").append(test_case).append(" ").append(list.stream().limit(10).collect(
                Collectors.joining(" "))).append("\n");
        }
        System.out.println(sb);
    }
}
