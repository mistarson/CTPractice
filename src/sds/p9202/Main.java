package sds.p9202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] mx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] my = {0, 0, -1, 1, -1, -1, 1, 1,};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};


    static int W, N;
    static char[][] map;
    static boolean[][] visited;
    static String answer;
    static int sum;
    static int count;
    static StringBuilder sb = new StringBuilder();
    static TrieNode root = new TrieNode();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        W = Integer.parseInt(br.readLine());

        for (int i = 0; i < W; i++) {
            insertTireNode(br.readLine());
        }

        br.readLine();
        N = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();

        for (int n = 0; n < N; n++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                String in = br.readLine();
                for (int k = 0; k < 4; k++) {
                    map[i][k] = in.charAt(k);
                }
            }

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (root.hasChild(map[y][x])) {
                        search(y, x, 1, root.getChild(map[y][x]));
                    }
                }
            }
            resultSb.append(sum);
            resultSb.append(" ");
            resultSb.append(answer);
            resultSb.append(" ");
            resultSb.append(count);
            resultSb.append("\n");
            root.clearHit();
            if (n != N - 1) {
                br.readLine();
            }
        }

        System.out.println(resultSb.toString());

    }


    static void insertTireNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int wordIndex = word.charAt(i) - 'A';
            if (current.children[wordIndex] == null) {
                current.children[word.charAt(i) - 'A'] = new TrieNode();
            }
            current = current.getChild(word.charAt(i));
        }
        current.isEnd = true;
    }

    static void search(int y, int x, int length, TrieNode node) {
        // 1. 체크인
        visited[y][x] = true;
        sb.append(map[y][x]);

        // 2. 목적지에 도달했는가? -> isEnd, isHit
        if (node.isEnd && !node.isHit) {
            node.isHit = true;
            sum += score[length];
            count++;
            String foundWord = sb.toString();
            if (compare(answer, foundWord) > 0) {
                answer = foundWord;
            }
        }
        // 3. 연결된 곳 순회 -> 8방
        for (int i = 0; i < 8; i++) {
            int tx = x + mx[i];
            int ty = y + my[i];
            // 4. 갈 수 있는 곳인가? -> 맵 영역, node가 자식 갖고, 방문 안한 곳
            if (tx >= 0 && tx < 4 && ty >= 0 && ty < 4) {
                if (!visited[ty][tx] && node.hasChild(map[ty][tx])) {
                    // 간다.
                    search(ty, tx, length + 1, node.getChild(map[ty][tx]));
                }
            }
        }
        // 6. 체크 아웃
        visited[y][x] = false;
        sb.deleteCharAt(length - 1);
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

class TrieNode {

    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    boolean isHit;

    boolean hasChild(char c) {
        return children[c - 'A'] != null;
    }

    TrieNode getChild(char c) {
        return children[c - 'A'];
    }

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
