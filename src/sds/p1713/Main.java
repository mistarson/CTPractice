package sds.p1713;

import java.io.FileInputStream;
import java.util.*;

public class Main {

    static int N, K;
    static Person[] people;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        people = new Person[101];

        List<Person> list = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            int num = sc.nextInt();

            // 새로운 후보
            if (people[num] == null) {
                people[num] = new Person(num, 0, 0, false);
            }
            // 사진틀에 있는 경우 -> count++
            if (people[num].isIn == true) {
                people[num].count++;
            } else {// 사진틀에 없는 경우 -> 하나 골라서 제거 후, 새 후보 추가가
                if (list.size() == N) {
                    Collections.sort(list);
                    Person p = list.remove(0);
                    p.isIn = false;
                }

                people[num].count = 1;
                people[num].isIn = true;
                people[num].timeStamp = k;
                list.add(people[num]);
            }
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.num));
        StringBuilder sb = new StringBuilder();
        for (Person person : list) {
            sb.append(person.num);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}

class Person implements Comparable<Person> {
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Person(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public int compareTo(Person o) {
        int comp1 = Integer.compare(count, o.count);
        if (comp1 == 0) {
            return Integer.compare(timeStamp, o.timeStamp);
        } else return comp1;
    }

}
