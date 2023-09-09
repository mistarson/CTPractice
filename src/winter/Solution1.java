package winter;

public class Solution1 {
    public static void main(String[] args) {
        String aabbbc = new Solution1().solution("helllllo");
        System.out.println(aabbbc);
    }
    public String solution(String line) {
        StringBuilder sb = new StringBuilder();
        char exChar = line.charAt(0);
        boolean canCompression = false;
        for (int i = 1; i < line.length(); i++) {
            if (exChar == line.charAt(i)) {
                canCompression = true;
                continue;
            }

            else {
                if (canCompression) {
                    sb.append(exChar).append("*");
                } else sb.append(exChar);
                exChar = line.charAt(i);
                canCompression = false;
            }
        }

        if (canCompression) {
            sb.append(exChar).append("*");
        } else sb.append(exChar);

        return sb.toString();
    }
}
