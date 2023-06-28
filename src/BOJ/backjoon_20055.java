package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Belt[] belt = new Belt[N * 2 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N * 2; i++) {
            int durability = Integer.parseInt(st.nextToken());
            belt[i] = new Belt(durability);
        }

        int zeroCnt = calculateZero(belt, N);
        int cycle = 0;
        while (zeroCnt < K) {
            rotate(belt, N);
            zeroCnt += moveRobot(belt, N);
            if (belt[1].durability > 0) {
                belt[1].durability--;
                belt[1].existRobot = true;
                if (belt[1].durability == 0) {
                    zeroCnt++;
                }
            }
            cycle++;
        }

        System.out.println(cycle);

    }

    static int calculateZero(Belt[] belt, int N) {
        int zeroCnt = 0;
        for (int i = 1; i <= N * 2; i++) {
            if (belt[i].durability == 0) {
                zeroCnt++;
            }
        }

        return zeroCnt;
    }

    static int moveRobot(Belt[] belt, int N) {
        int zeroCnt = 0;
        for (int i = N - 1; i > 0; i--) {
            // 현재 벨트에 로봇이 존재하고, 다음 벨트에 로봇이 존재하지 않고, 다음 벨트의 내구도가 0 이상이면
            if (belt[i].existRobot && !belt[i + 1].existRobot && belt[i + 1].durability > 0) {
                if (i != N - 1) {
                    belt[i + 1].existRobot = true;
                }
                belt[i].existRobot = false;
                belt[i + 1].durability--;
                if (belt[i + 1].durability == 0) {
                    zeroCnt++;
                }
            }
        }

        return zeroCnt;
    }

    static void rotate(Belt[] belt, int N) {
        Belt tempBelt = new Belt(belt[1].durability, belt[1].existRobot);
        belt[1].carryValue(belt[N * 2].durability, belt[N * 2].existRobot);
        for (int i = N * 2; i > 2; i--) {
            belt[i].carryValue(belt[i - 1].durability, belt[i - 1].existRobot);
        }
        belt[2].carryValue(tempBelt.durability, tempBelt.existRobot);
        belt[N].deleteRobot();
    }

    static class Belt {
        int durability;
        boolean existRobot;

        public Belt(int durability) {
            this.durability = durability;
        }

        public Belt(int durability, boolean existRobot) {
            this.durability = durability;
            this.existRobot = existRobot;
        }

        public void carryValue(int durability, boolean existRobot) {
            this.durability = durability;
            this.existRobot = existRobot;
        }

        public void deleteRobot() {
            this.existRobot = false;
        }
    }
}
