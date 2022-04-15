class Solution {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int count = n;
        for (int i = 0; i < n; i++) {
            answer[i] = "";
            while (count-- > 0) {
                if (arr1[i] % 2 + arr2[i]%2 == 0) {
                    answer[i] =  " " + answer[i];
                } else {
                    answer[i] = "#" + answer[i];
                }
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            count = n;
        }

        return answer;
    }


}