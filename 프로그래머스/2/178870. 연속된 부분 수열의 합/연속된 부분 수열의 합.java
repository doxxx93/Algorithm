class Solution {

    public int[] solution(int[] sequence, int k) {
        int[] prefix = new int[sequence.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + sequence[i - 1];
        }
        // return left and right index of the shortest subarray
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            int right = findRight(prefix, i, k);
            if (right == prefix.length) {
                break;
            }
            int sum = prefix[right] - prefix[i];
            if (sum == k) {
                if (right - i < min) {
                    min = right - i;
                    result[0] = i;
                    result[1] = right - 1;
                }
            }
        }

        return result;
    }

    private int findRight(int[] prefix, int left, int k) {
        int lo = left;
        int hi = prefix.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = prefix[mid] - prefix[left];
            if (sum < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
