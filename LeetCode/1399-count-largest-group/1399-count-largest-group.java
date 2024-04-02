class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=1; i<=n; i++ ){
            int cur = i;
            int sum = 0;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            map.merge(sum, 1, Integer::sum);
        }
        List<Integer> res = new ArrayList<>(map.values());
        Collections.sort(res, Collections.reverseOrder());
        int max = res.get(0);
        int count = 0;
        for(int x : res) {
            if (x == max) {
                count++;
                continue;
            }
            return count;
        }
        return count;
    }
}