package backjoon;

import java.io.*;

public class backjoon_5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int minTime = 0;

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            String s = String.valueOf(word.charAt(i));
            minTime += checkTime(s);
        }

        bw.write(String.valueOf(minTime));
        bw.flush();
    }

    private static int checkTime(String s) {
        switch (s) {
            case "A":
            case "B":
            case "C":
                return 3;
            case "D":
            case "E":
            case "F":
                return 4;
            case "G":
            case "H":
            case "I":
                return 5;
            case "J":
            case "K":
            case "L":
                return 6;
            case "M":
            case "N":
            case "O":
                return 7;
            case "P":
            case "Q":
            case "R":
            case "S":
                return 8;
            case "T":
            case "U":
            case "V":
                return 9;
            case "W":
            case "X":
            case "Y":
            case "Z":
                return 10;
        }
        return 0;
    }
}
