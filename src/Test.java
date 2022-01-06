//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.stream.Collectors;
//
//class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int totalCount = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < totalCount; i++) {
//
//            String S = br.readLine();
//            StringTokenizer st = new StringTokenizer(S);
//
//            int count = Integer.parseInt(st.nextToken());
//
//            String str = st.nextToken();
//            List<String> list = new ArrayList<>();
//
//            for (int j = 0; j < str.length(); j++) {
//                for (int z = 0; z < count; z++) {
//                    list.add(String.valueOf(str.charAt(j)));
//                }
//            }
//
//            String P = list.stream().map(String::valueOf).collect(Collectors.joining());
//            System.out.println(P);
//
//
//        }
//
//    }
//}
