package programmers.키패드누르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution(numbers, hand));


    }

    static String solution(int[] numbers, String hand) {
        KeyPad leftPosition = new KeyPad(3, 0);
        KeyPad rightPosition = new KeyPad(3, 2);

        Map<Integer, KeyPad> keyPadMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                keyPadMap.put(i, new KeyPad(3, 1));
                continue;
            }
            if (i % 3 == 0) {
                keyPadMap.put(i, new KeyPad(i / 3 - 1, 2));
            } else {
                keyPadMap.put(i, new KeyPad(i / 3, i % 3 - 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            boolean leftChangeCheck = false;
            boolean rightChangeCheck = false;

            int number = numbers[i];
            if (number == 1 || number == 4 || number == 7) {
                leftChangeCheck = true;
            } else if (number == 3 || number == 6 || number == 9) {
                rightChangeCheck = true;
            } else {

                int leftDistance = distance(keyPadMap.get(number), leftPosition);
                int rightDistance = distance(keyPadMap.get(number), rightPosition);

                if (leftDistance == rightDistance) {
                    if (hand.equals("left")) {
                        leftChangeCheck = true;
                    } else {
                        rightChangeCheck = true;
                    }
                } else if (leftDistance < rightDistance) {
                    leftChangeCheck = true;
                } else {
                    rightChangeCheck = true;
                }
            }

            if (leftChangeCheck) {
                leftPosition.setY(keyPadMap.get(number).y);
                leftPosition.setX(keyPadMap.get(number).x);
                sb.append("L");
            } else if (rightChangeCheck) {
                rightPosition.setY(keyPadMap.get(number).y);
                rightPosition.setX(keyPadMap.get(number).x);
                sb.append("R");
            }
        }
        return sb.toString();

    }

    static class KeyPad {
        int y;
        int x;

        public KeyPad(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    static int distance(KeyPad a, KeyPad b) {
        return Math.abs(a.y - b.y) + Math.abs(a.x - b.x);
    }

}
