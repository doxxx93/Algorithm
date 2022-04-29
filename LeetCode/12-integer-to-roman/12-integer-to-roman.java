class Solution {

    private static final int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
        1};
    private static final String[] romanNumerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L",
        "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {

        int point = 0;
        StringBuilder numeralResult = new StringBuilder();
        while (num > 0) {
            if (num >= values[point]) {
                numeralResult.append(romanNumerals[point]);
                num -= values[point];
            } else {
                point++;
            }
        }
        return numeralResult.toString();
    }
}