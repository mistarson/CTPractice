package last;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String[] recode = {"jack:9,10,13,9,15", "jerry:7,7,14,10,17","jean:0,0,11,20,0", "alex:21,2,7,11,4","kevin:8,4,5,0,0", "brown:3,5,16,3,18",
        "ted:0,8,0,0,8", "lala:0,12,0,7,9", "hue:17,16,8,6,10", "elsa:11,13,10,4,13"};
        String[] strings = new Solution2().solution2(recode);
        System.out.println(Arrays.toString(strings));
        String[] answer = {"alex","brown","elsa","jerry","hue","jack","lala","kevin","ted","jean"};
    }

    public String[] solution2(String[] record) {
        StringTokenizer st;
        Map<String, Person> personMap = new HashMap<>();
        List<List<Record>> courseRecordList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            courseRecordList.add(new ArrayList<>());
        }

        for (String s : record) {
            st = new StringTokenizer(s, ":");
            String name = st.nextToken();
            String records = st.nextToken();
            st = new StringTokenizer(records, ",");

            int clearCourse = 0;
            int totalCourseTime = 0;
            int difficultestCourse = -1;
            for (int i = 0; i < 5; i++) {
                int time = Integer.parseInt(st.nextToken());
                totalCourseTime += time;
                if (time > 0) {
                    clearCourse++;
                    difficultestCourse = i + 1;
                    courseRecordList.get(i).add(new Record(name, time));
                }
            }

            personMap.put(name, new Person(clearCourse, difficultestCourse, totalCourseTime, name));
        }

        for (List<Record> records : courseRecordList) {
            Collections.sort(records);
            int goldCnt = records.size() % 12 == 0 ? records.size() / 12 :  (records.size() / 12) + 1;
            int silverCnt = records.size() % 4 == 0 ? records.size() / 4 :  (records.size() / 4) + 1;
            int bronzeCnt = records.size() % 2 == 0 ? records.size() / 2 :  (records.size() / 2) + 1;

            int idx = 0;
            for (int i = idx; i < idx + goldCnt; i++) {
                if (i >= records.size()) {
                    break;
                }
                personMap.get(records.get(i).personName).addGold();
            }
            idx += goldCnt;

            for (int i = idx; i < idx + silverCnt; i++) {
                if (i >= records.size()) {
                    break;
                }
                personMap.get(records.get(i).personName).addSilver();
            }
            idx += silverCnt;

            for (int i = idx; i < idx + bronzeCnt; i++) {
                if (i >= records.size()) {
                    break;
                }
                personMap.get(records.get(i).personName).addBronze();
            }
        }

        List<Person> personList = new ArrayList<>();
        for (String name : personMap.keySet()) {
            personList.add(personMap.get(name));
        }
        Collections.sort(personList);
        String[] result = new String[personList.size()];
        for (int i = 0; i < personList.size(); i++) {
            result[i] = personList.get(i).name;
        }

        return result;
    }

    static class Person implements Comparable<Person>{
        int clearCourse=0;
        int difficultestCourse=0;
        int gold = 0;
        int silver = 0;
        int bronze = 0;
        int totalCourseTime=0;
        String name;

        public Person(int clearCourse, int difficultestCourse, int totalCourseTime, String name) {
            this.clearCourse = clearCourse;
            this.difficultestCourse = difficultestCourse;
            this.totalCourseTime = totalCourseTime;
            this.name = name;
        }

        public void addGold() {
            gold++;
        }

        public void addSilver() {
            silver++;
        }

        public void addBronze() {
            bronze++;
        }

        @Override
        public int compareTo(Person o) {
            int comp1 = Integer.compare(o.clearCourse, clearCourse);
            if (comp1 == 0) {
                int comp2 = Integer.compare(o.difficultestCourse, difficultestCourse);
                if (comp2 == 0) {
                    int comp3 = Integer.compare(o.gold, gold);
                    if (comp3 == 0) {
                        int comp4 = Integer.compare(o.silver, silver);
                        if (comp4 == 0) {
                            int comp5 = Integer.compare(o.bronze, bronze);
                            if (comp5 == 0) {
                                int comp6 = Integer.compare(totalCourseTime, o.totalCourseTime);
                                if (comp6 == 0) {
                                    return name.compareTo(o.name);
                                }
                            } else return comp5;

                        } else return comp4;
                    }else return comp3;

                } else return comp2;
            }
            return comp1;
        }
    }

    static class Record implements Comparable<Record>{
        String personName;
        int time;

        public Record(String personName, int time) {
            this.personName = personName;
            this.time = time;
        }

        @Override
        public int compareTo(Record o) {
            return Integer.compare(time, o.time);
        }
    }
}
