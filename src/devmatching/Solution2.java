package devmatching;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String[] maps = {"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..", ".M.XXEXQ", "KL.TBBBQ"};
        int solution = new Solution2().solution(maps);
        System.out.println(solution);
    }

    public int solution(String[] maps) {
        int answer = 0;

        Map<Character, Integer> totalInfluenceArea = new HashMap<>();
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != '.' && !isVisited[i][j]) {
                    startWar(i, j, maps, isVisited, totalInfluenceArea);
                }
            }
        }

        for (Character key : totalInfluenceArea.keySet()) {
            answer = Math.max(answer, totalInfluenceArea.get(key));
        }
        return answer;
    }

    static void startWar(int r, int c, String[] maps, boolean[][] isVisited, Map<Character, Integer> totalInfluenceArea) {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Map<Character, Integer> influence = new HashMap<>();

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(r, c));
        isVisited[r][c] = true;

        int maxInfluence = 0;
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            char currentInfluence = maps[current.r].charAt(current.c);
            influence.put(currentInfluence, influence.getOrDefault(currentInfluence, 0) + 1);
            maxInfluence = Math.max(maxInfluence, influence.get(currentInfluence));

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc, maps.length, maps[0].length()) && maps[nr].charAt(nc) != '.' && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    queue.add(new Position(nr, nc));
                }

            }

        }

        List<Character> maxInfluenceList = new ArrayList<>();
        for (Character key : influence.keySet()) {
            if (influence.get(key) == maxInfluence) {
                maxInfluenceList.add(key);
                totalInfluenceArea.put(key, totalInfluenceArea.getOrDefault(key, 0) + influence.get(key));
            }
        }

        maxInfluenceList.sort(Collections.reverseOrder());

        char finalInfluence = maxInfluenceList.get(0);
        for (Character key : influence.keySet()) {
            if (influence.get(key) < maxInfluence) {
                totalInfluenceArea.put(finalInfluence,
                        totalInfluenceArea.getOrDefault(finalInfluence, 0) + influence.get(key));
            }
        }

    }

    static boolean inRange(int r, int c, int rSize, int cSize) {
        return r >= 0 && r < rSize && c >= 0 && c < cSize;
    }


    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
