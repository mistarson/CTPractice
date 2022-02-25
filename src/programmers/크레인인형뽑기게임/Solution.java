package programmers.크레인인형뽑기게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));

    }

    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> boardList = new ArrayList<Stack<Integer>>();
        Stack<Integer> basket = new Stack<>();

        for (int i = 0; i <= board.length; i++) {
            boardList.add(new Stack<Integer>());
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 1; j <= board.length; j++) {
                if (board[i][j - 1] == 0) {
                    continue;
                }
                boardList.get(j).add(board[i][j - 1]);
            }
        }

        for (int i = 0; i < moves.length; i++) {
            int position = moves[i];
            if (boardList.get(position).isEmpty()) {
                continue;
            }
            Integer popDoll = boardList.get(position).pop();
            if (basket.size() > 0 && basket.peek().equals(popDoll)) {
                basket.pop();
                answer++;
                continue;
            }
            basket.push(popDoll);
        }
        return answer * 2;
    }
}
