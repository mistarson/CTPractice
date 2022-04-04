package programmers.level1.최소직사각형;

public class Solution {
    static int solution(int[][] sizes) {
        int widthMax = Integer.MIN_VALUE;
        int heightMax = Integer.MIN_VALUE;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if (sizes[i][0] > widthMax) {
                widthMax = sizes[i][0];
            }
            if (sizes[i][1] > heightMax) {
                heightMax = sizes[i][1];
            }
        }
        return widthMax * heightMax;
    }
}
