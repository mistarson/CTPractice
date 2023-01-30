package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_2800 {
    static Set<String> caseList = new TreeSet<>(); // 사전순으로 정렬하기 위한 TreeSet

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracketStr = br.readLine();

        printAllCase(bracketStr, true);

        StringBuilder sb = new StringBuilder();
        for (String str : caseList) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    static void printAllCase(String bracketStr, boolean isFirst) {

        //첫번째 문자열은 정답에 포함되지 않기 때문에 무시하기 위해 isFirst변수 사용
        if (isFirst) {
            isFirst = false;
        } else {
            caseList.add(bracketStr);
        }

        // 괄호의 쌍이 맞으면 재귀함수
        Stack<Bracket> bracketStack = new Stack<>();
        for (int i = 0; i < bracketStr.length(); i++) {
            char c = bracketStr.charAt(i);
            if (c == '(') {
                bracketStack.add(new Bracket(i, c));
            } else if (c == ')') {
                Bracket bracket = bracketStack.pop();
                String removeBracketStr = removeBracketPair(bracketStr, bracket.index, i);
                printAllCase(removeBracketStr, isFirst);
            }
        }
    }

    // 여는 괄호, 닫는 괄호를 제거한 문자열을 추출하기 위한 함수
    static String removeBracketPair(String bracketStr, int openIndex, int closeIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bracketStr.length(); i++) {
            if (i == openIndex || i == closeIndex) {
                continue;
            }
            sb.append(bracketStr.charAt(i));
        }

        return sb.toString();
    }

    // 괄호의 인덱스와 어떤 괄호인지 담기 위한 클래스
    static class Bracket {
        int index;
        char kind;

        public Bracket(int index, char kind) {
            this.index = index;
            this.kind = kind;
        }
    }

}
