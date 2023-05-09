class Solution {
    public String solution(int[] numLog) {
        var sb = new StringBuilder();
        for (int i = 1; i < numLog.length; i++) {
            sb.append(switch (numLog[i] - numLog[i - 1]) {
                case 1 -> 'w';
                case -1 -> 's';
                case 10 -> 'd';
                case -10 -> 'a';
                default -> ""; // Add a default case to handle other values
            });
        }
        return sb.toString();
    }
}
