package backjoon;

import java.util.Scanner;

public class backjoon_2588 {

    public static void main(String[] args) {

        Integer A = 0;
        Integer B = 0;

        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        String NumberA = String.valueOf(A);
        String NumberB = String.valueOf(B);

        Integer[] ArrNumberA = new Integer[NumberA.length()];
        Integer[] ArrNumberB = new Integer[NumberB.length()];

        ArrNumberA = NumberSplit(NumberA);
        ArrNumberB = NumberSplit(NumberB);

        System.out.println(ArrNumberB[2]*A);
        System.out.println(ArrNumberB[1]*A);
        System.out.println(ArrNumberB[0]*A);
        System.out.println(A*B);

    }

    static Integer[] NumberSplit(String StringNumber) {
        Integer[] ArrNumber = new Integer[StringNumber.length()];
        for (int i = 0; i < StringNumber.length(); i++) {
            ArrNumber[i] = StringNumber.charAt(i) - '0';
        }
        return ArrNumber;
    }
}
