package programmers.소수찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int M;
    static char[] numberArr;
    static boolean[] isVisited;
    static List<String> list = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    static int solution(String numbers) {
        int answer = 0;
        M = numbers.length();
        numberArr = new char[M];
        isVisited = new boolean[M];

        for (int i = 0; i < M; i++) {
            numberArr[i] = numbers.charAt(i);
        }

        dfs(0);

        answer = list.stream().distinct().collect(Collectors.toList()).size();

        return answer;
    }

    static void dfs(int length) {

        if (length > 0) {
            if(isPrime(sb.toString())) {
                list.add(sb.toString());
            }
        }

        if (length == M) {
            return;
        }

        for (int i = 0; i < M ; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sb.append(numberArr[i]);
                if (sb.charAt(0) == '0') {
                    sb.deleteCharAt(sb.length() - 1);
                    isVisited[i] = false;
                    continue;
                }
                dfs(length + 1);
                isVisited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static boolean isPrime(String numbers) {
        int number = Integer.parseInt(numbers);
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
