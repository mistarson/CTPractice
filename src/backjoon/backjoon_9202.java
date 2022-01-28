package backjoon;

import sds.p9202.TrieNode;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_9202 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] mx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] my = {0, 0, -1, 1, -1, -1, 1, 1,};
    static int[] scores = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static char[][] map;
    static boolean[][] visited;
    static TrieNode trie = new TrieNode();
    static String answer;
    static int sum;
    static int count;

    public static void main(String[] args) throws IOException {

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String word = br.readLine();
            insertWord(word);
        }

        br.readLine();
        int b = Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++) {
            makeMap(map);
            findWord(map);
        }
        StringBuilder resultSb = new StringBuilder();

    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        boolean isHit;

        void clearHit() {
            isHit = false;
            for (int i = 0; i < children.length; i++) {
                TrieNode child = children[i];
                if (child != null) {
                    child.clearHit();
                }
            }
        }

    }

    static void insertWord(String word) {
        TrieNode current = trie;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'A';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    static void makeMap(char[][] map) throws IOException {
        for (int i = 0; i < 4; i++) {
            String word = br.readLine();
            for (int j = 0; j < 4; j++) {
                map[i][j] = word.charAt(j);
            }
        }
    }

    static void findWord(char[][] map) {
        sum = 0;
        count = 0;
        answer = "";
        map = new char[4][4];
        visited = new boolean[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (trie.children[map[y][x] - 'A'] != null) {
                    dfs(y,x,1,trie.children[map[y][x] - 'A']);

                }
            }
        }
    }

    static void dfs(int y, int x, int length, TrieNode node) {
        visited[y][x] = true;
        sb.append(map[y][x]);

        if (node.isEnd && !node.isHit) {
            node.isHit = true;
            sum += scores[length];
            count++;
            String foundWord = sb.toString();
            if (compare(answer, foundWord) > 0) {
                answer = foundWord;
            }

            for (int i = 0; i < 8; i++) {
                int tx = x + mx[i];
                int ty = y + my[i];
                if (tx >= 0 && tx < 4 && ty >= 0 && ty < 4) {
                    if (!visited[ty][tx] && node.children[map[ty][tx] - 'A'] != null) {
                        dfs(ty,tx,length+1, node.children[map[ty][tx] - 'A']);
                    }
                }
            }
            visited[y][x] = false;
            sb.deleteCharAt(length - 1);
        }


    }

    static int compare(String str1, String str2) {
        int comp1 = Integer.compare(str2.length(), str1.length());
        if (comp1 == 0) {
            return str1.compareTo(str2);
        } else {
            return comp1;
        }

    }

}
