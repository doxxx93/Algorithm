class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDuration = releaseTimes[0];
        char maxChar = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            if (duration > maxDuration || (duration == maxDuration && keysPressed.charAt(i) > maxChar)) {
                maxDuration = duration;
                maxChar = keysPressed.charAt(i);
            }
        }
        return maxChar;
    }
}
