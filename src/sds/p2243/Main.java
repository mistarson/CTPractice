//package sds.p2243;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static long[] arr;
//    static long[] result = new long[1000001];
//    static int MAX = 1000000;
//    static int S = 1;
//
//    public static void main(String[] args) throws IOException {
//
//        result[0] = 0;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int count = Integer.parseInt(br.readLine());
//
//        while (S < MAX) {
//            S * 2;
//        }
//
//        for (int i = 0; i < count; i++) {
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int A = Integer.parseInt(st.nextToken());
//
//            if (A == 2) {
//                long target = Long.parseLong(st.nextToken());
//                long diff = Long.parseLong(st.nextToken());
//
//
//                UpdateTD(1,S,1, target, diff);
//
//            } else {
//                //인덱스받아서 업데이트문치기
//
//            }
//        }
//    }
//
//    static void UpdateTD(int left, int right, int node, long target, long diff) {
//
//        if (left <= target && right >= target) {
//            result[node] += diff;
//            if(left != right) {
//                if (result[node * 2] != 0) {
//                    UpdateTD(left, (left + right) / 2, node * 2, target, diff);
//                }
//                if (result[node * 2 + 1] != 0) {
//                    UpdateTD((left + right) / 2 + 1, right, node * 2 + 1, target, diff);
//                }
//            }
//        }
//    }
//
//    static long Query(int left, int right, int node, int count) {
//        // 1. Leaf에 도착햇을 때 -> 사탕 번호 반환
//        if (left == right) {
//            return left;
//        }
//
//        int mid = (left + right) / 2;
//        // 2. 왼쪽이 > count -> 왼쪽으로 이동
//        if (tree[node * 2] >= count) {
//            return Query(left, right, node * 2, count)
//        }
//        // 3. 왼쪽 < count -> 오른쪽으로 이동
//        else {
//            return Query(mid + 1, right, node * 2 + 1, count - tree[node * 2]);
//        }
//        //
//    }
//
//
//}
