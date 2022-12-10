import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answer = new ArrayList<>();
        List<String> guess = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answer.add(br.readLine());
        }
        for (int i = 0; i < 3; i++) {
            guess.add(br.readLine());
        }
        int[] answerOccasions = new int[26];
        int[] guessOccasions = new int[26];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answer.get(i).length(); j++) {
                answerOccasions[answer.get(i).charAt(j) - 'A']++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < guess.get(i).length(); j++) {
                guessOccasions[guess.get(i).charAt(j) - 'A']++;
            }
        }

        int green = 0;
        int yellow = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer.get(i).charAt(j) == guess.get(i).charAt(j)) {
                    green++;
                    answerOccasions[answer.get(i).charAt(j) - 'A']--;
                    guessOccasions[guess.get(i).charAt(j) - 'A']--;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (answerOccasions[i] > 0 && guessOccasions[i] > 0) {
                yellow += Math.min(answerOccasions[i], guessOccasions[i]);
            }
        }
        System.out.println(green);
        System.out.println(yellow);
    }
}
