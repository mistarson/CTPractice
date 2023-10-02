package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(seq[0]);

        for (int i = 1; i < seq.length; i++) {
            int last = list.get(list.size() - 1);
            if (last < seq[i]) {
                list.add(seq[i]);
            } else {
                replace(list, seq[i]);
            }
        }

        System.out.println(list.size());
    }

    static void replace(List<Integer> list, int num) {
        int low = 0;
        int high = list.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // 마지막 2개가 남았다면 왼쪽이 아니라 보다 큰 오른쪽 원소를 선택해야 해서 < O, <= X
            if (list.get(mid) < num) {
                low = mid + 1;
            } else high = mid;
        }

        list.set(low, num);
    }
}
