class Solution {
    public String reorderSpaces(String text) {
        int sp = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sp++;
            }
        }
        String[] words = text.trim().split("\\s+");
        int n = words.length;
        int g = n - 1;
        if (g == 0) {
            return words[0] + " ".repeat(sp);
        }
        int btw = sp / g;
        int tr = sp % g;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(words[i]);
            if (i < n - 1) {
                sb.append(" ".repeat(btw));
            }
        }
        sb.append(" ".repeat(tr));
        return sb.toString();
    }
}