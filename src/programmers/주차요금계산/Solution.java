package programmers.주차요금계산;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] solution = solution(fees, records);

        System.out.println(Arrays.toString(solution));

    }

    static int[] solution(int[] fees, String[] records) {
        int[] answer;

        Map<String, Integer> carRecords = new HashMap<>();
        Map<String, Integer> resultRecords = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            int time = timeTrans(st.nextToken());
            String carNumber = st.nextToken();
            String inAndOut = st.nextToken();

            if (inAndOut.equals("IN")) {
                carRecords.put(carNumber, time);
            } else {
                Integer inTime = carRecords.get(carNumber);
                carRecords.remove(carNumber);
                resultRecords.put(carNumber, resultRecords.getOrDefault(carNumber, 0) + (time - inTime));
            }
        }

        for (String carNumber : carRecords.keySet()) {
            int inTime = carRecords.get(carNumber);
            resultRecords.put(carNumber, resultRecords.getOrDefault(carNumber, 0) + 1439 - inTime);
        }


        List<String> list = new ArrayList<>();
        for (String carNumber : resultRecords.keySet()) {
            int fee = billing(resultRecords.get(carNumber), fees);
            resultRecords.put(carNumber, fee);
            list.add(carNumber);
        }
        Collections.sort(list);
        answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultRecords.get(list.get(i));
        }


        return answer;
    }

    static int timeTrans(String str) {
        int sum1 = (str.charAt(0) - '0') * 600;
        int sum2 = (str.charAt(1)- '0') * 60;
        int sum3 = (str.charAt(3)- '0') * 10;
        int sum4 = (str.charAt(4) - '0');

        return sum1 + sum2 + sum3 + sum4;
    }

    static int billing(int time, int[] fees) {
        if (time <= fees[0]) {
            return fees[1];
        } else {
            int overTime = time - fees[0];
            int nanun = 0;
            if (overTime % fees[2] != 0) {
                nanun = overTime / fees[2] + 1;
            } else {
                nanun = overTime / fees[2];
            }
            return fees[1] + nanun * fees[3];
        }
    }
}
