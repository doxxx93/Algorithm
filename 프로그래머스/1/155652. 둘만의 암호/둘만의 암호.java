class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] skipCheck = new boolean[26];

        // Initialize the skipCheck array.
        for (char skipChar : skip.toCharArray()) {
            skipCheck[skipChar - 'a'] = true;
        }

        // Process each character in the input string.
        for (char currentChar : s.toCharArray()) {
            int currentPosition = currentChar - 'a';
            int moveCount = index;

            // Move "index" steps, skipping any characters as necessary.
            while (moveCount > 0) {
                currentPosition++;
                if (currentPosition == 26) {
                    currentPosition = 0; // Wrap around from 'z' to 'a'.
                }
                if (!skipCheck[currentPosition]) {
                    // Only decrement the move count if we are not skipping this character.
                    moveCount--;
                }
            }

            // Append the final character to the result.
            answer.append((char) (currentPosition + 'a'));
        }

        return answer.toString();
    }
}