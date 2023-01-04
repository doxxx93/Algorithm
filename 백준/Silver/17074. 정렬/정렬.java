import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = 0;
        int r = n - 1;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] > arr[i]) {
                r = i - 1;
                break;
            }
        }
        
        if (r == n-1){
            System.out.println(n);
            return;
        }
        l = r + 1;
		for (int i = l+1; i < n; i++) {
			if (arr[i-1] > arr[i]) {
                System.out.println(0);
				return;
			}
		}
		if (r == 0) {
			if (l == n-1) {
                System.out.println(2);
			}
			else {
				if (arr[r] <= arr[l + 1]) {
                    System.out.println(2);
				}
				else {
                    System.out.println(1);
                }
			}
		}
		else {
			if (l == n - 1) {
				if (arr[r - 1] <= arr[l]) {
                    System.out.println(2);
                }
				else{
                    System.out.println(1);
                }			
            }
			else {
				int t = 0;
				if (arr[r - 1] <= arr[l]) {
                    t++;
                }
				if (arr[r] <= arr[l + 1]) {
                    t++;
                }
                System.out.println(t);
			}
		}
    }
}