import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        while (p-- > 0) {
            String s = br.readLine();
            // TTT TTH THT THH HTT HTH HHT HHH
            int[] arr = new int[8];
            for (int i = 0; i < 38; i++) {
                if (s.charAt(i) == 'T') {
                    if (s.charAt(i + 1) == 'T') {
                        if (s.charAt(i + 2) == 'T') {
                            arr[0]++;
                        } else {
                            arr[1]++;
                        }
                    } else {
                        if (s.charAt(i + 2) == 'T') {
                            arr[2]++;
                        } else {
                            arr[3]++;
                        }
                    }
                } else {
                    if (s.charAt(i + 1) == 'T') {
                        if (s.charAt(i + 2) == 'T') {
                            arr[4]++;
                        } else {
                            arr[5]++;
                        }
                    } else {
                        if (s.charAt(i + 2) == 'T') {
                            arr[6]++;
                        } else {
                            arr[7]++;
                        }
                    }
                }
            }
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7]);
        }
    }
}