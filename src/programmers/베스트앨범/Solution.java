package programmers.베스트앨범;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] solution = new Solution().solution(genres, plays);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> songPlayCountMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            songPlayCountMap.put(genre, songPlayCountMap.getOrDefault(genre, 0) + play);
            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new ArrayList<>());
            }
            List<Song> songList = songMap.get(genre);
            songList.add(new Song(i, play));
        }

        List<String> sortedGenres = new ArrayList<>(songPlayCountMap.keySet());
        sortedGenres.sort((a, b) -> songPlayCountMap.get(b) - songPlayCountMap.get(a));

        List<Integer> answer = new ArrayList<>();
        for (String sortedGenre : sortedGenres) {
            List<Song> songList = songMap.get(sortedGenre);
            songList.sort((a, b) -> b.cnt - a.cnt);
            answer.add(songList.get(0).id);
            if (songList.size() > 1) {
                answer.add(songList.get(1).id);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    class Song{

        int id;
        int cnt;

        public Song(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }
    }
}
