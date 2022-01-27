package backjoon;

import java.io.*;
import java.util.*;

public class backjoon_1713 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, count;
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        count = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {

            int newStudentNumber = Integer.parseInt(st.nextToken());

            if (!isSameStudent(newStudentNumber)) {
                if (students.size() != N) {
                    students.add(new Student(newStudentNumber, 1, i));
                } else {
                    Collections.sort(students);
                    students.remove(students.size()-1);
                    students.add(new Student(newStudentNumber, 1, i));
                }
            }
        }
        Collections.sort(students, Comparator.comparingInt(o -> o.number));

        for (int i = 0; i < students.size(); i++) {
            bw.write(students.get(i).number+" ");
        }
        bw.flush();
    }

    static class Student implements Comparable<Student>{
        int number;
        int voted;
        int index;

        public Student(int number, int voted, int index) {
            this.number = number;
            this.voted = voted;
            this.index = index;
        }

        @Override
        public int compareTo(Student o) {
            int comp1 = Integer.compare(o.voted, voted);
            if (comp1 == 0) {
                return Integer.compare(o.index, index);
            } else return comp1;
        }
    }

    static boolean isSameStudent(int newStudentNumber) {
        for (int i = 0; i < students.size(); i++) {
            int studentNumber = students.get(i).number;
            if (studentNumber == newStudentNumber) {
                students.get(i).voted++;
                return true;
            }
        }
        return false;
    }
}
