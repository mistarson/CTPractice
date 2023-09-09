package devmatching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        String[] registered_list = {"card", "ace13", "ace"};
        String new_id = "ace";
        String solution = new Solution1().solution(registered_list, new_id);
        System.out.println(solution);
    }

    public String solution(String[] registered_list, String new_id) {
        String answer = "";
        Set<String> registerdListSet = new HashSet<>(Arrays.asList(registered_list));

        int std = 0;
        for (int i = 0; i < new_id.length(); i++) {
            if (!(new_id.charAt(i) <= 'z' && new_id.charAt(i) >= 'a')) {
                std = i;
                break;
            }
        }

        String[] separate = separate(new_id, std);

        while (!isPossible(separate, registerdListSet)) {
            int newN = Integer.parseInt(separate[1]) + 1;
            separate[1] = String.valueOf(newN);
        }

        String recommandId = makeString(separate);

        return recommandId;
    }

    static String[] separate(String new_id, int std) {
        String[] SN = new String[2];

        if (std == 0) {
            SN[0] = new_id;
            SN[1] = "0";
        } else {
            SN[0] = new_id.substring(0, std);
            SN[1] = new_id.substring(std);
        }

        return SN;
    }

    public boolean isPossible(String[] separate, Set<String> registerdListSet) {
        String recommandId = makeString(separate);

        if (registerdListSet.contains(recommandId)) {
            return false;
        }

        return true;
    }

    public String makeString(String[] separate) {
        StringBuilder sb = new StringBuilder();
        sb.append(separate[0]);
        if (!separate[1].equals("0")) {
            sb.append(separate[1]);
        }
        return sb.toString();
    }
}
