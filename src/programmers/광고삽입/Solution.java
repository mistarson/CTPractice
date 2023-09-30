package programmers.광고삽입;

import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTimeSecond = strToSecond(play_time);
        int advTimeSecond = strToSecond(adv_time);

        if (playTimeSecond <= advTimeSecond) {
            return "00:00:00";
        }

        int[] viewing = new int[playTimeSecond + 1];
        for (String log : logs) {
            String[] startAndEnd = log.split("-");
            int startSecond = strToSecond(startAndEnd[0]);
            int endSecond = strToSecond(startAndEnd[1]);

            for (int j = startSecond; j < endSecond; j++) {
                viewing[j]++;
            }
        }

        long max = 0;
        for (int i = 0; i < advTimeSecond; i++) {
            max += viewing[i];
        }

        int advStartTime = 0;
        long now = max;
        for (int i = advTimeSecond; i < playTimeSecond; i++) {
            now = now - viewing[i - advTimeSecond] + viewing[i];
            if (now > max) {
                advStartTime = i - advTimeSecond + 1;
                max = now;
            }
        }


        return secondToStr(advStartTime);
    }

    static int strToSecond(String str) {
        st = new StringTokenizer(str, ":");

        int h = Integer.parseInt(st.nextToken()) * 3600;
        int m = Integer.parseInt(st.nextToken()) * 60;
        int s = Integer.parseInt(st.nextToken());

        return h + m + s;
    }

    static String secondToStr(int second) {
        StringBuilder sb = new StringBuilder();
        int h = second / 3600;
        if (h < 10) {
            sb.append("0");
        }
        sb.append(h).append(":");

        second = second % 3600;
        int m = second / 60;
        if (m < 10) {
            sb.append("0");
        }
        sb.append(m).append(":");
        int s = second % 60;
        if (s < 10) {
            sb.append("0");
        }
        sb.append(s);


        return sb.toString();
    }
}
