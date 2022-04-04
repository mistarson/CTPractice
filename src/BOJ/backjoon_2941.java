package BOJ;

import java.io.*;

public class backjoon_2941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int alphacnt = 0;
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 1) {
                alphacnt++;
                break;
            }
            String s1 = String.valueOf(word.charAt(i));
            if (s1.equals("c")) {
                String s2 = String.valueOf(word.charAt(i + 1));
                if (s2.equals("-") || s2.equals("=")) {
                    i++;
                }

            } else if (s1.equals("d")) {
                String s2 = String.valueOf(word.charAt(i + 1));
                if (s2.equals("-")) {
                    i++;
                } else if (s2.equals("z")) {
                    if (i == word.length() - 2) {
                        alphacnt++;
                        continue;
                    }
                    String s3 = String.valueOf(word.charAt(i + 2));
                    if (s3.equals("=")) {
                        i += 2;
                    }
                }
            } else if (s1.equals("l")) {
                String s2 = String.valueOf(word.charAt(i + 1));
                if (s2.equals("j")) {
                    i++;
                }
            } else if (s1.equals("n")) {
                String s2 = String.valueOf(word.charAt(i + 1));
                if (s2.equals("j")) {
                    i++;
                }
            } else if (s1.equals("s")) {
                String s2 = String.valueOf(word.charAt(i + 1));
                if (s2.equals("=")) {
                    i++;
                }
            } else if (s1.equals("z")) {
                String s2 = String.valueOf(word.charAt(i + 1));
                if (s2.equals("=")) {
                    i++;
                }
            }

            alphacnt++;
        }
        bw.write(String.valueOf(alphacnt));
        bw.flush();
    }
}
