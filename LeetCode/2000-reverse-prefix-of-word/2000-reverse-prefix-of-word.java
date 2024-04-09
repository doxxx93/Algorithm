class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        sb.append(word.substring(0, index + 1));
        sb.reverse();
        sb.append(word.substring(index + 1));
        return sb.toString();
    }
}