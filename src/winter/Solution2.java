package winter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int n = 6;
        int[] student = {6, 1, 4, 2, 5, 1, 3, 3, 1, 6, 5};
        int[] point = {3, 2, 5, 3, 4, 2, 4, 2, 3, 2, 2};
        int solution = new Solution2().solution(n, student, point);
        System.out.println(solution);

    }
    public int solution(int n, int[] student, int[] point) {
        int answer = 0;
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            studentList.add(new Student(i, 0));
        }

        for (int i = 0; i < student.length; i++) {
            int exStudentClass = 0;
            for (int j = 0; j < studentList.size(); j++) {
                if (studentList.get(j).num == student[i]) {
                    if (j >= n / 2) {
                        exStudentClass = 1;
                    }else exStudentClass = 2;
                    studentList.get(j).addScore(point[i]);
                    break;
                }
            }

            Collections.sort(studentList);

            int studentClass = 0;
            for (int j = 0; j < studentList.size(); j++) {
                if (studentList.get(j).num == student[i]) {
                    if (j >= n / 2) {
                        studentClass = 1;
                    }else studentClass = 2;
                    break;
                }
            }

            if (exStudentClass != studentClass) {
                answer++;
            }
        }

        return answer;
    }

    static class Student implements Comparable<Student>{

        int num;
        int score;

        public Student(int num, int score) {
            this.num = num;
            this.score = score;
        }

        public void addScore(int score) {
            this.score += score;
        }

        @Override
        public int compareTo(Student o) {
            int comp1 = Integer.compare(o.score, score);
            if (comp1 == 0) {
                return Integer.compare(num, o.num);
            } else {
                return comp1;
            }
        }
    }
}
