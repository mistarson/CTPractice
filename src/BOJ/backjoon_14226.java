package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class backjoon_14226 {
    static final int MAX_SIZE = 2000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        boolean[][] isVisited = new boolean[MAX_SIZE][MAX_SIZE];

        Queue<Imoticon> queue = new LinkedList<>();
        queue.add(new Imoticon(0, 0, 1));

        int answer = 0;
        while (!queue.isEmpty()) {
            Imoticon imoticon = queue.poll();

            if (imoticon.imoticonCnt == S) {
                answer = imoticon.takenTime;
                break;
            }

            // 화면에 있는 이모티콘 모두 복사하기
            if (!isVisited[imoticon.imoticonCnt][imoticon.imoticonCnt]) {
                isVisited[imoticon.imoticonCnt][imoticon.imoticonCnt] = true;
                queue.add(new Imoticon(imoticon.imoticonCnt, imoticon.takenTime + 1, imoticon.imoticonCnt));
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            int totalImoticon = imoticon.copyCnt + imoticon.imoticonCnt;
            if (totalImoticon < 2000 && !isVisited[imoticon.copyCnt][totalImoticon]) {
                isVisited[imoticon.copyCnt][totalImoticon] = true;
                queue.add(new Imoticon(imoticon.copyCnt, imoticon.takenTime + 1, totalImoticon));
            }


            // 화면에 있는 이모티콘 중 하나를 삭제
            if (imoticon.imoticonCnt >= 3 && !isVisited[imoticon.copyCnt][imoticon.imoticonCnt - 1]) {
                isVisited[imoticon.copyCnt][imoticon.imoticonCnt - 1] = true;
                queue.add(new Imoticon(imoticon.copyCnt, imoticon.takenTime + 1, imoticon.imoticonCnt - 1));
            }

        }

        System.out.println(answer);
    }

    static class Imoticon {
        int copyCnt;
        int takenTime;
        int imoticonCnt;

        public Imoticon(int copyCnt, int takenTime, int imoticonCnt) {
            this.copyCnt = copyCnt;
            this.takenTime = takenTime;
            this.imoticonCnt = imoticonCnt;
        }
    }
}
