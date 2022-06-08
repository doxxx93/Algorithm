class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int same = compare(lottos, win_nums);
        int count0 = count0(lottos);

        int max = same + count0;
        int min = same;

        answer[0] = rank(max);
        answer[1] = rank(min);

        return answer;
    }

    public int rank(int num) {
        if (7 - num >= 6) {
            return 6;
        } else {
            return 7 - num;

        }
    }


    /*method counts number of 0 in int array lottos*/
    public int count0(int[] lottos) {
        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                count++;
            }
        }
        return count;
    }

    /*method return number of same value between 2 int arrays*/
    public int compare(int[] lottos, int[] win_nums) {
        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

}