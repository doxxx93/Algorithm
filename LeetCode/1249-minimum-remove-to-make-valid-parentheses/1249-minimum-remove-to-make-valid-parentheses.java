class Solution {

    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int o = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                o++;
            } else if (arr[i] == ')') {
                if (o == 0) {
                    arr[i] = '0';
                    continue;
                }
                o--;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (o > 0 && arr[i] == '(') {
                arr[i] = '0';
                o--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c == '0') {
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
