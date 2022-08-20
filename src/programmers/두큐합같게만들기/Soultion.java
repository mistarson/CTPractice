package programmers.두큐합같게만들기;

public class Soultion {

    public static void main(String[] args) {
        int[] queue1 = {30,20,40,20};
        int[] queue2 = {1, 1, 1, 1};
        int solution = new Soultion().solution(queue1, queue2);
        System.out.println(solution);
    }

    public int solution(int[] queue1, int[] queue2) {


        int length = queue1.length;
        int[] tq = new int[length * 2];

        long q1Sum = 0;
        int idx = 0;
        for (int i = 0; i < length; i++) {
            tq[idx++] = queue1[i];
            q1Sum += queue1[i];
        }

        long q2Sum = 0;
        for (int i = 0; i < length; i++) {
            tq[idx++] = queue2[i];
            q2Sum += queue2[i];
        }

        int cnt = 0;
        int left = 0;
        int right = length;
        while (left < right && right < length * 2) {
            if (q1Sum < q2Sum) {
                q2Sum -= tq[right];
                q1Sum += tq[right];
                right++;
            } else if (q1Sum > q2Sum) {
                q1Sum -= tq[left];
                q2Sum += tq[left];
                left++;
            } else {
                return cnt;
            }
            cnt++;
        }

        return -1;
    }
}
