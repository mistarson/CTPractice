package backjoon;

import java.io.*;
import java.util.*;

public class backjoon_1713 {

    static class student implements Comparable<student> {
        int number = 0;
        int voted = 0;
        int lastIndex = 0;

        public student(int number, int voted, int lastIndex) {
            this.number = number;
            this.voted = voted;
            this.lastIndex = lastIndex;
        }

        @Override
        public String toString() {
            return "student{" +
                    "number=" + number +
                    ", voted=" + voted +
                    ", lastIndex=" + lastIndex +
                    '}';
        }

        @Override
        public int compareTo(student o) {
            int comp1 = Integer.compare(o.voted, voted);
            if (comp1 == 0) {
                return Integer.compare(o.lastIndex, lastIndex);
            } else return comp1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<student> students = new ArrayList<>();

        int picture = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isSame = false;

        for (int i = 0; i < count; i++) {

            int number = Integer.parseInt(st.nextToken()); // 후보 받기

            //사진틀이 모두 찼다면
            if (students.size() == picture) {
                isSame = false;
                // 같은 후보가 있는 지 확인
                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).number == number) {
                        students.get(j).voted++;
                        isSame = true;
                    }
                }
                // 같은 후보가 없으면
                if (!isSame) {
                    Collections.sort(students);
                    students.remove(2);
                    students.add(new student(number, 1, i));
                }

            }

            // 사진틀이 남는 경우
            else {
                isSame = false;
                // 같은 후보가 있는 지 확인
                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).number == number) {
                        students.get(j).voted++;
                        isSame = true;
                    }
                }
                // 같은 후보가 없으면
                if (!isSame) {
                    students.add(new student(number, 1, i));
                }
            }
        }

        for (int i = 0; i < students.size(); i++) {
            if (i != students.size() - 1) {
                bw.write(String.valueOf(students.get(i).number) + " ");
            } else {
                bw.write(String.valueOf(students.get(i).number));

            }
        }

        bw.flush();
    }

}
