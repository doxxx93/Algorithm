class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int x : salary) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            sum += x;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}