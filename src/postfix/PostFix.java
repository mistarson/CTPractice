package postfix;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class PostFix {
    static StringTokenizer st;
    static String numberPattern = "^[0-9]*$";

    public static void main(String[] args) {
        String infix = "( 14 + 9 + 4 * 5 )";
        System.out.println(calculate(infix));
    }

    static int calculate(String infix) {
        String postfix = convertPostfix(infix);

        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(postfix);
        int countTokens = st.countTokens();
        for (int i = 0; i < countTokens; i++) {
            String s = st.nextToken();
            if (Pattern.matches(numberPattern, s)) {
                stack.push(Integer.parseInt(s));
            } else {
                char op = s.charAt(0);
                int B = stack.pop();
                int A = stack.pop();
                int result = calculateAB(A, B, op);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    static String convertPostfix(String infix) {

        HashMap<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('+', 1);
        priorityMap.put('-', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);

        st = new StringTokenizer(infix);
        int size = st.countTokens();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            String str = st.nextToken();
            if (Pattern.matches(numberPattern, str)) {
                sb.append(str).append(" ");
            } else {
                char op = str.charAt(0);
                if (op == ')') {
                    while (stack.peek() != '(') {
                        sb.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                    continue;
                }

                while (!stack.isEmpty()) {
                    if (op == '(') {
                        break;
                    }

                    if (stack.peek() != '(' && priorityMap.get(op) <= priorityMap.get(stack.peek())) {
                        sb.append(stack.pop()).append(" ");
                    } else break;
                }
                stack.push(op);
            }
        }

        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();

    }

    static int calculateAB(int A, int B, char op) {

        int result = 0;

        switch (op) {
            case '+':
                result = A + B;
                break;
            case '-':
                result = A - B;
                break;
            case '*':
                result = A * B;
                break;
            case '/':
                result = A / B;
                break;
        }
        return result;
    }

}
