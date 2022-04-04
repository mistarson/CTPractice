package programmers.level1.신규아이디추천;

public class Solution {
    //TODO 정규표현식으로 바꿀 것
    public static void main(String[] args) {

        String new_id = "abcdefghijklmn.p";

        System.out.println(solution(new_id));

    }
    static String solution(String new_id) {

        String level1 = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        int dotCnt = 0;
        for (int i = 0; i < level1.length(); i++) {
            if (level2Method(level1.charAt(i))) {
                if (level1.charAt(i) == '.') {
                    if (dotCnt == 1) {
                        continue;
                    }
                    dotCnt++;
                } else {
                    dotCnt = 0;
                }
                sb.append(level1.charAt(i));
            }
        }
        String level3 = sb.toString();

        if (level3.length() == 0) {
            return "aaa";
        }

        String level45 = level45Method(level3);

        String level6 = level45;
        if (level6.length() >= 16) {
            level6 = level6.substring(0, 15);
            level6 = level45Method(level6);
        }

        if (level6.length() <= 2) {
            sb = new StringBuilder();
            for (int i = 0; i < level6.length(); i++) {
                sb.append(level6.charAt(i));
            }
            while (sb.length() < 3) {
                sb.append(level6.charAt(level6.length()-1));
            }
            level6 = sb.toString();
        }


        return level6;
    }

    static boolean level2Method(char c) {
        // 대문자                     소문자                   숫자
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.';
    }

    static String level45Method(String str) {
        if (str.charAt(0) == '.') {
            str = str.substring(1);
            if (str.length() == 0) {
                return "aaa";
            }
        }

        if (str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 1);
            if (str.length() == 0) {
                return "aaa";
            }
        }

        return str;
    }
}
