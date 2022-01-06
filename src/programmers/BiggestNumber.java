package programmers;//import java.util.*;
//
//import static java.lang.Character.*;
//
//public class BiggestNumber {
//    public static void main(String[] args) {
//        String[] registered_list = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
//        String new_id = "asds";
//
//        Solution solution = new Solution();
//        String answer = solution.solution(registered_list, new_id);
//
//        System.out.println("answer = " + answer);
//
//    }
//
//
//    static class Solution {
//        public String solution(String[] registered_list, String new_id) {
//            String answer = "";
//
//
//            reValidation(registered_list, new_id);
//
//
//            return answer;
//
//        }
//
//        private String reValidation(String[] registered_list, String new_id) {
//            for (int i = 0; i < registered_list.length; i++) {
//                String newRecommand_id = new String(new_id);
//                if (registered_list[i] == new_id) {
//                    if (Character.isLetter(new_id.charAt(new_id.length() - 1))) {
//                        newRecommand_id = + "1";
//
//                        System.out.println("newRecommand_id = " + newRecommand_id);
//                    } else {
//                        String s = new_id.replaceAll("[^0-9]", "");
//                        int NNumber = Integer.parseInt(s);
//                        NNumber = +1;
//
//                        String NString = String.valueOf(NNumber);
//
//                        newRecommand_id.replace(s, NString);
//                    }
//                }
//            }
//            return "";
//        }
//
//    }
//}
