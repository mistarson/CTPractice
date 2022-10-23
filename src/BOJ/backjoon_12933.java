package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();

        int idx = 0;
        int cnt = 0;
        int maxCnt = 0;
        char[] duck = new char[2500];
        for (int i = 0; i < sound.length(); i++) {
            if (sound.charAt(i) == 'q') {
                duck[idx++] = 'u';
                maxCnt = Math.max(maxCnt, ++cnt);
                continue;
            }
            if (!isRight(duck, sound.charAt(i))) {
                System.out.println(-1);
                return;
            }
            if (sound.charAt(i) == 'k') {
                cnt--;
            }
        }

        for (int i = 0; i < duck.length; i++) {
            if (duck[i] == 'f' || duck[i] == 0) {
                if (duck[i] == 0) {
                    break;
                }
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(maxCnt);
    }

    static boolean isRight(char[] duck, char sound) {
        boolean isRight = false;
        for (int i = 0; i < duck.length; i++) {
            if (duck[i] == sound) {
                switch (sound) {
                    case 'u':
                        duck[i] = 'a';
                        break;
                    case 'a':
                        duck[i] = 'c';
                        break;
                    case 'c':
                        duck[i] = 'k';
                        break;
                    case 'k':
                        duck[i] = 'f';
                        break;
                }
                isRight = true;
                break;
            }
        }

        return isRight;
    }
}
