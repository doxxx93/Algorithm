import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[3][];
        for (int i = 0; i < 3; i++) {
            arr[i] = new int[Integer.parseInt(st.nextToken())];
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                for (int k = 0; k < arr[2].length; k++) {
                    answer = Math.min(answer, Math.abs(
                        Math.max(Math.max(arr[0][i], arr[1][j]), arr[2][k]) - Math.min(
                            Math.min(arr[0][i], arr[1][j]), arr[2][k])));
                }
            }
        }
        System.out.println(answer);
    }
}