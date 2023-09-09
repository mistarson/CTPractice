package gabia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        long solution = new Solution2().solution(3);
        System.out.println(solution);
    }

    public long solution(long n) {

        long exSize = 0;
        long size = 1;
        int cnt = 1;
        while (size < n) {
            cnt++;
            exSize = size;
            size += size + 1;
        }

        System.out.println(cnt);

        long[] seq = new long[cnt];

        for (int i = 0; i < seq.length; i++) {
            seq[i] = (long) Math.pow(3, i);
        }

        List<Long> list = new ArrayList<>();
        list.add(seq[cnt - 1]);

        getNumber(seq[cnt - 1], seq, list, 0);
        System.out.println(list);

        Collections.sort(list);

        return list.get((int) (n - exSize) - 1);
    }

    public void getNumber(long sum, long[] seq, List<Long> list, int start) {

        for (int i = start; i < seq.length - 1; i++) {
            list.add(sum + seq[i]);
            getNumber(sum + seq[i], seq, list, i + 1);
        }
    }


}
