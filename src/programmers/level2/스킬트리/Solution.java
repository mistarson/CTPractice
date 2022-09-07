package programmers.level2.스킬트리;

import java.util.*;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            skillMap.put(skill.charAt(i), i);
        }

        // 전체 스킬트리 돌리는 부분
        for (int i = 0; i < skill_trees.length; i++) {

            String learnSkillStr = skill_trees[i];
            boolean[] skillCheck = new boolean[skill.length()];
            boolean falseFlag = false;

            // 각각의 스킬트리 돌리는 부분
            for (int j = 0; j < learnSkillStr.length(); j++) {
                char learnSkill = learnSkillStr.charAt(j);
                if (skillMap.containsKey(learnSkill)) {
                    int idx = skillMap.get(learnSkill);
                    if (idx == 0) {
                        skillCheck[idx] = true;
                        continue;
                    }
                    if (skillCheck[idx - 1]) {
                        skillCheck[idx] = true;
                    } else {
                        falseFlag = true;
                        break;
                    }
                }
            }
            if (!falseFlag) {
                answer++;
            }
        }
        return answer;
    }
}
