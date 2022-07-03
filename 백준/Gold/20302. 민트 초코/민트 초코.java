import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static String[] arr;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println("mint chocolate");
            return;
        }
        // 정수 */ 정수 */ 정수 ...
        arr = new String[2 * n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }
        List<Integer> tList = new ArrayList<>();
        if (Integer.parseInt(arr[0]) == 0) {
            System.out.println("mint chocolate");
            return;
        }

        tList.add(Math.abs(Integer.parseInt(arr[0])));

        List<Integer> dList = new ArrayList<>();
        for (int i = 2; i < arr.length; i += 2) {
            if (arr[i - 1].equals("*")) {
                tList.add(Math.abs(Integer.parseInt(arr[i])));
            } else {
                dList.add(Math.abs(Integer.parseInt(arr[i])));
            }
        }

        int[] nums = new int[100001];
        for (int num : tList) {
            if (num == 0) {
                System.out.println("mint chocolate");
                return;
            }
            for (int j = 2; j * j <= num; j++) {
                while (num % j == 0) {
                    nums[j]++;
                    num /= j;
                }
            }
            if (num != 1) {
                nums[num]++;
            }
        }

        for (int num : dList) {
            for (int j = 2; j * j <= num; j++) {
                while (num % j == 0) {
                    nums[j]--;
                    num /= j;
                }
            }
            if (num != 1) {
                nums[num]--;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                System.out.println("toothpaste");
                return;
            }
        }
        System.out.println("mint chocolate");
    }
}

