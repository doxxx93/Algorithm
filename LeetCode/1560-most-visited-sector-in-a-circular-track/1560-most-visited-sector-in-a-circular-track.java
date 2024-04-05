class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[n + 1];

        for (int i = 1; i < rounds.length; i++ ) {
            int cur = rounds[i];
            int prev = rounds[i-1];

            // cur > prev -> prev < x <=  cur count[x]++
            if (cur > prev) {
                for (int x = prev; x < cur; x++) {
                    count[x]++;
                }
                continue;
            }
            // cur < prev -> prev < x <= n / 1 <= x <= cur count[x]++
            for (int x = prev; x <= n; x++) {
                count[x]++;
            }
            for (int x= 1; x < cur; x++) {
                count[x]++;
            }
        }
        count[rounds[rounds.length -1]]++;

        int max = 0;
        for (int m : count) {
            max = Math.max(max, m);
        }

        List<Integer> res = new ArrayList<>();
        for (int x =0; x <=n; x++) {
            if (count[x] == max) {
                res.add(x);
            }
        }

        return res;
    }
}