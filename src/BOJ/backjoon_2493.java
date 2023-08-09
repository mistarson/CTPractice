package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjoon_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tops = new int[N];
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        Stack<Top> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                list.add(0);
                stack.push(new Top(tops[i], i + 1));
            } else {
                while (!stack.isEmpty()) {
                    Top popTop = stack.peek();
                    if (popTop.height < tops[i]) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            list.add(0);
                        }
                    } else {
                        list.add(popTop.index);
                        break;
                    }
                }
                stack.push(new Top(tops[i], i + 1));

            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer idx : list) {
            sb.append(idx).append(" ");
        }

        System.out.println(sb);

    }

    static class Top {
        int height;
        int index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
