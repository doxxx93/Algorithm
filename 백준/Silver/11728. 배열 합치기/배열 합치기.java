import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int index1 = 0;
        int index2 = 0;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (index1 < N && index2 < M) {
            if (A[index1] < B[index2]) {
                bw.write(A[index1] + " ");
                index1++;
            } else {
                bw.write(B[index2] + " ");
                index2++;
            }
        }
        while (index1 < N) {
            bw.write(A[index1] + " ");
            index1++;
        }
        while (index2 < M) {
            bw.write(B[index2] + " ");
            index2++;
        }

        bw.flush();
        bw.close();
    }
}