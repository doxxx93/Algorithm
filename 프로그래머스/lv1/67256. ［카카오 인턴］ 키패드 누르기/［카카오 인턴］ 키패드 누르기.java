class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10;
        int right = 12;

        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }
            switch (number % 3) {
                case 0 -> {
                    answer.append("R");
                    right = number;
                }
                case 1 -> {
                    answer.append("L");
                    left = number;
                }
                case 2 -> {
                    if (getDistance(left, number) < getDistance(right, number)) {
                        answer.append("L");
                        left = number;
                    } else if (getDistance(left, number) > getDistance(right, number)) {
                        answer.append("R");
                        right = number;
                    } else {
                        answer.append(hand.equals("right") ? "R" : "L");
                        if (hand.equals("right")) {
                            right = number;
                        } else {
                            left = number;
                        }
                    }
                }
            }
        }
        return answer.toString();
    }


    public int getDistance(int index, int number) {
        int x = Math.abs(index - number) / 3;
        int y = Math.abs(index - number) % 3;
        return x + y;
    }
}