class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int[] zero = {-1};

        if (arr.length == 1) {
            return zero;
        } else {
            answer = eliminate(arr);
        }
        return answer;
    }
    /*method eliminate the smallest number in array arr*/
    public int[] eliminate(int[] arr) {
        int[] answer = {};
        int min = arr[0];
        int minIndex = 0;

        if (arr.length == 1) {
            return arr;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            answer = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                if (minIndex > i) {
                    answer[i] = arr[i];
                } else {
                    answer[i] = arr[i + 1];
                }
            }
        }
        return answer;
    }
}