import java.util.HashSet;
import java.util.Iterator;

class Solution {

    HashSet<Integer> numberSet = new HashSet<>();

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void recursive(String comb, String others) {
        if (!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public int solution(String numbers) {
        recursive("", numbers);
        int count = 0;
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) {
                count++;
            }
        }

        return count;
    }
}