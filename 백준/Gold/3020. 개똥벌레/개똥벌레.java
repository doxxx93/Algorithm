/**
 * 반딧불이가 X크기의 석순(종유석)을 파괴하면 X크기보다 크거나 같은 크기의 석순(종유석)도 모두 파괴한다.
 * 즉 석순(종유석)의 상대적 순서는 무관하다.
 * 서로 종류만 분류하고, 바이너리 서치를 사용하여 파괴된 장애물 수를 결정할 수 있다.
 * x크기에 대한 장애물에 대해서 x미만인 석순(종유석)의 수를 사전 처리할 수 있다.
 */
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        n /= 2;
        int[] stalagmiti = new int[n];
        int[] stalaktiti = new int[n];
        for (int i = 0; i < n; i++) {
            stalagmiti[i] = Integer.parseInt(br.readLine());
            stalaktiti[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(stalagmiti);
        Arrays.sort(stalaktiti);
        int min = 1000000000;
        int count = 0;
        for (int y = 0; y < h; y++) {
            int obstacle = n - lowerBound(stalagmiti, y + 1) + n - lowerBound(stalaktiti, h - y);
            if (obstacle < min) {
                min = obstacle;
                count = 0;
            }
            if (obstacle == min) {
                count++;
            }
        }
        System.out.println(min + " " + count);
    }

    public static int lowerBound(int[] arr, int x) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}