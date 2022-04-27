class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String columnTitle = "ZY";
        int answer = solution.titleToNumber(columnTitle);
        System.out.println(answer);
    }

    public int titleToNumber(String columnTitle) {
        if (columnTitle.length() == 0) {
            return 0;
        }

        int answer = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            answer += alphabetToNumber(columnTitle.charAt(i)) * (int) Math.pow(26,
                columnTitle.length() - i - 1);
        }

        return answer;

    }

    public int alphabetToNumber(char c) {
        return c - 64;
    }


}