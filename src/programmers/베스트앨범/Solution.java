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
        Map<String, Integer> mostPlayGenres = new HashMap<>();
        Map<String, List<Music>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int cnt = plays[i];
            mostPlayGenres.put(genre, mostPlayGenres.getOrDefault(genre, 0) + cnt);
            if (!map.containsKey(genre)) {
                map.put(genre, new ArrayList<>());
            }
            map.get(genre).add(new Music(i, cnt));
        }

        List<Music> musicList = new ArrayList<>();
        for (String key : mostPlayGenres.keySet()) {
            musicList.add(new Music(key, mostPlayGenres.get(key)));
        }

        Collections.sort(musicList);
        List<Integer> bestAlbumList = new ArrayList<>();
        for (Music music : musicList) {
            List<Music> musicListByGenre = map.get(music.genre);
            Collections.sort(musicListByGenre);
            for (int i = 0; i < map.get(music.genre).size(); i++) {
                if (i == 2) {
                    break;
                }
                bestAlbumList.add(musicListByGenre.get(i).id);
            }
        }

        int[] answer = new int[bestAlbumList.size()];
        for (int i = 0; i < bestAlbumList.size(); i++) {
            answer[i] = bestAlbumList.get(i);
        }

        return answer;
    }

    static class Music implements Comparable<Music> {

        String genre;
        int id;
        int cnt;

        public Music(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }

        public Music(String genre, int cnt) {
            this.genre = genre;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Music o) {
            int comp1 = Integer.compare(o.cnt, cnt);
            if (comp1 == 0) {
                return Integer.compare(id, o.id);
            } else return comp1;
        }
    }
}
