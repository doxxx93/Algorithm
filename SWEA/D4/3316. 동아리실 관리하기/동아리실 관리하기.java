import java.io.*;
import java.util.*;

/**
 * SWEA 3316. 동아리방 청소
 * N일간 동아리 방을 청소한다.
 * 동아리 부원은 A, B, C, D로 4명이다.
 * 4개의 원소 경우의 수는 2^4 = 16개이다.
 * 이 중 아무도 참가하지 않는 경우는 없으므로, 실질적인 경우의 수는 15개이다.
 * x번째 비트 값이 1이면 x번째 부원이 참가한다는 의미이다.
 * 이진수로 이를 표현하게 되면 0001(A) ~ 1111(ABCD) 이다.
 * 각 테스트 케이스마다 길이가 10000 이하인 문자열이 주어지므로, N ≤ 10000이다.
 * 1,000,000,007로 나눈 나머지를 출력해야 하므로, MOD = 1,000,000,007로 설정한다.
 */
class Solution {

    static final int MOD = 1000000007;
    static long[][] dp = new long[10000][16];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            // dp 배열 초기화
            Arrays.stream(dp).forEach(a -> Arrays.fill(a, 0));
            String input = br.readLine();

            for (int day = 0; day < input.length(); day++) {
                int key = 1 << (input.charAt(day) - 'A');
                // i == 0인 경우는 아무도 참가하지 않는 경우이므로 제외한다.
                for (int i = 1; i < 16; i++) {
                    if (day == 0) {
                        // 첫날은 A가 관리자이므로, A가 참가한 경우만 1로 초기화한다.
                        if ((i & key) != 0 && (i & 1) != 0) {
                            dp[day][i] = 1;
                        }
                        continue;
                    }
                    // 2번째 날부터는 이전 날의 경우의 수를 누적한다.
                    // 이전 날의 경우의 수가 0이면, continue
                    if (dp[day - 1][i] == 0) {
                        continue;
                    }
                    // 이전 날의 경우의 수가 0이 아니면, 현재 날의 경우의 수를 누적한다.
                    for (int j = 1; j < 16; j++) {
                        if ((j & key) != 0 && (i & j) != 0) {
                            dp[day][j] = (dp[day][j] + dp[day - 1][i]) % MOD;
                        }
                    }
                }
            }
            long count = Arrays.stream(dp[input.length() - 1]).reduce(0, (a, b) -> (a + b) % MOD);

            sb.append("#").append(test_case).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
