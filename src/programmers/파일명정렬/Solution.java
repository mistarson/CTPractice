package programmers.파일명정렬;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] solution = new Solution().solution(files);

        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = detach(o1);
            String[] file2 = detach(o2);

            int comp1 = file1[0].compareTo(file2[0]);
            if (comp1 == 0) {
                int number1 = Integer.parseInt(file1[1]);
                int number2 = Integer.parseInt(file2[1]);
                return Integer.compare(number1, number2);
            }
            return comp1;
        });

        return files;

    }

    private String[] detach(String str) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();

        int idx = 0;
        for (; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (c >= '0' && c <= '9') {
                break;
            }
            head.append(c);
        }

        for (; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (!(c >= '0' && c <= '9')) {
                break;
            }
            number.append(c);
        }

        String[] file = {head.toString().toLowerCase(), number.toString()};

        return file;
    }
}
