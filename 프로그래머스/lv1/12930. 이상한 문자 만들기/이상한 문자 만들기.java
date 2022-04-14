class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int[] arr = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                count = 0;
            } else {
                arr[i] = count;
                count++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 == 0) {
                answer += s.toUpperCase().charAt(i);
            } else {
                answer += s.toLowerCase().charAt(i);
            } 
        }

        return answer;
    }
}