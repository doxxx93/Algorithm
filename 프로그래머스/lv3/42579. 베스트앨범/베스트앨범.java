import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlays = new TreeMap<>();
        Map<String, List<Integer>> genreSongs = new TreeMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlays.merge(genre, play, Integer::sum);
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(i);
        }

        List<String> genreList = new ArrayList<>(genrePlays.keySet());

        // 장르 리스트를 정렬하는 2가지 방법이 있다.
        // 속도 차이는 별로 없다.
        // 1-1. sort 메서드 내부 Comparator 구현 (람다식)
        genreList.sort((o1, o2) -> genrePlays.get(o2) - genrePlays.get(o1));
        // 1-2. sort 메서드 내부 Comparator 구현 (comparingInt)
        // genreList.sort(Comparator.comparingInt(genrePlays::get).reversed());
        // 2. Collections.sort 메서드 사용
        // Collections.sort(genreList, (o1, o2) -> genrePlays.get(o2) - genrePlays.get(o1));

        List<Integer> answer = new ArrayList<>();

        for (String genre : genreList) {
            List<Integer> songs = genreSongs.get(genre);
            songs.sort((o1, o2) -> {
                if (plays[o1] == plays[o2]) {
                    return o1 - o2;
                }
                return plays[o2] - plays[o1];
            });
            songs.stream().limit(2).forEach(answer::add);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
