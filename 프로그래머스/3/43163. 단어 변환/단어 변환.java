import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(target::equals)) {
            return 0;
        }

        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (int j = 0; j < words.length; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    int diff = 0;
                    for (int k = 0; k < current.length(); k++) {
                        if (current.charAt(k) != words[j].charAt(k)) {
                            diff++;
                        }
                    }

                    if (diff == 1) {
                        if (words[j].equals(target)) {
                            return level;
                        }
                        visited[j] = true;
                        queue.add(words[j]);
                    }
                }
            }
        }

        return 0;
    }
}
