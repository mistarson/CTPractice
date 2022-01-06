//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Test {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int X = Integer.parseInt(br.readLine());
//        int count = 0;
//
//        for (int i = 1; i <= X; i++) {
//
//            if (i < 100) {
//                count++;
//                continue;
//            }
//
//            List<Integer> list = new ArrayList<>();
//            String numStr = String.valueOf(i);
//            for (int j = 0; j < numStr.length(); j++) {
//                list.add(numStr.charAt(j) - '0');
//            }
//            int gongcha =  0;
//            if (list.get(0) > list.get(1)) {
//                gongcha = -(list.get(0) - list.get(1));
//            } else {
//                gongcha = list.get(1) - list.get(0);
//            }
//            for (int j = 1; j < list.size() - 1; j++) {
//
//                if (list.get(j) + gongcha != list.get(j + 1)) {
//                    break;
//                }
//                if (j == list.size()-2) count++;
//
//            }
//
//        }
//        System.out.println(count);
//
//
//    }
//
//
//}
