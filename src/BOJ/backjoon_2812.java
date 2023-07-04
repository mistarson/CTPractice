package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjoon_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        char[] numbers = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            int number = numbers[i] - '0';
            if (stack.isEmpty()) {
                stack.push(number);
            } else {
                while (!stack.isEmpty() && stack.peek() < number && K > 0) {
                    K--;
                    stack.pop();
                }
                stack.push(number);
            }
        }

        while (K-- > 0) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.insert(0, stack.pop());
        }

        System.out.println(sb);
    }
}
