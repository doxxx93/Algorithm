import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlays = new TreeMap<>();
        Map<String, List<Integer>> genreSongs = new TreeMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + play);
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(i);
        }

        List<String> genreList = new ArrayList<>(genrePlays.keySet());

        genreList.sort((o1, o2) -> genrePlays.get(o2) - genrePlays.get(o1));

        List<Integer> answer = new ArrayList<>();

        for (String genre : genreList) {
            List<Integer> songs = genreSongs.get(genre);
            songs.sort((o1, o2) -> {
                if (plays[o1] == plays[o2]) {
                    return o1 - o2;
                }
                return plays[o2] - plays[o1];
            });
            answer.add(songs.get(0));
            if (songs.size() > 1) {
                answer.add(songs.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
