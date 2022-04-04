package programmers.level2.오픈채팅방;

import java.util.*;

public class Solution {
    static Map<String, String> uidMap = new HashMap<>();
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        solution(record);
    }
    static String[] solution(String[] record) {
        List<Records> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String type = st.nextToken();
            String uid = st.nextToken();
            if (type.equals("Leave")) {
                list.add(new Records(type, uid));
            } else {
                String name = st.nextToken();
                if (type.equals("Enter")) {
                    list.add(new Records(type, uid));
                    uidMap.put(uid, name);
                } else {
                    uidMap.put(uid, name);
                }
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).getRecord();
        }

        return result;
    }

    static class Records {
        String type;
        String uid;

        public Records(String type, String uid) {
            this.type = type;
            this.uid = uid;
        }

        public String getRecord() {
            StringBuilder sb = new StringBuilder();
            sb.append(uidMap.get(uid));
            if (type.equals("Enter")) {
                sb.append("님이 들어왔습니다.");
            } else {
                sb.append("님이 나갔습니다.");
            }
            return sb.toString();
        }
    }
}
