class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0; // 답 초기화
        int left, right = 0; // 범위의 왼쪽과 오른쪽 초기화
        int coverage = 2 * w + 1; // 각 기지국의 범위 초기화

        // 기지국이 설치 되어 있는 아파트의 수만큼을 도는 루프
        for (int i = 0; i < stations.length; i++) {
            // 첫번째 기지국의 경우 기지국의 왼쪽 범위가 첫번쨰 아파트를 포함하는지 여부를 확인해야한다.
            if (i == 0) {
                // 포함하지 않는 경우 필요한 기지국의 수를 answer에 더한다.
                if (stations[i] - w > 1) {
                    answer += calc(stations[i] - w - 1, coverage);
                }
                // 기지국의 오른쪽 끝
                right = stations[i] + w;
                continue;
            }
            // 현재 기지국 범위의 왼쪽끝 (현재 - 1)번째 기지국 범위의 오른쪽 끝 사이의 거리를
            // 각 기지국의 범위(2w+1)로 나누어 증설이 필요한 기지국 개수를 구할 것이다.
            // 현재 기지국 범위의 왼쪽 끝
            left = stations[i] - w;
            // 현재 기지국 범위의 왼쪽끝과 
            if (left - right > 0) {
                answer += calc(left - right - 1, coverage);
            }
            // 기존의 범위 오른쪽 끝을 현재 기지국 범위의 오른쪽 끝으로 바꿔준다.
            right = stations[i] + w;
        }
        // 마지막 기지국의 범위가 마지막 아파트에 미치지 않는다면 증설이 필요한 기지국의 개수를 더해준다.       
        if (right < n) {
            answer += calc(n - right, coverage);
        }

        return answer;
    }

    // [전파가 전달되지 않는 부분]을 [기지국의 범위]로 나눈다.
    // 증설이 필요한 기지국 개수(정수)를 계산할 수 있다.
    // 나머지가 있는 경우 + 1
    public int calc(int seg, int coverage) {
        return (seg % coverage == 0) ? seg / coverage : seg / coverage + 1;
    }
}