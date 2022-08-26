package programmers.멀쩡한사각형;

public class Solution {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        long solution = new Solution().solution(w, h);

        System.out.println(solution);
    }

    public long solution(int w, int h) {
        int gcd = gcd(w, h);

        return (long) w * h - ((((long) w / gcd + (long) h / gcd) - 1) * gcd);
    }

    static int gcd(int w, int h) {
        if (w < h) {
            return gcd(h, w);
        }

        if (h == 0) {
            return w;
        }

        return gcd(h, w % h);
    }
}
