class Solution {
    public int lengthOfLastWord(String s) {

        List<String> strings = Arrays.stream(s.trim().split(" ")).toList();

        return strings.get(strings.size() - 1).length();

    }
}