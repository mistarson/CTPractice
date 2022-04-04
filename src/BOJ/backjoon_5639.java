package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class backjoon_5639 {

    static List<Integer> list = new ArrayList<>();
    static Node node;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        node = new Node(Integer.parseInt(str));

        while (true) {
            String n = br.readLine();
            if (n.equals("") || n == null || n.length() <= 0) {
                break;
            } else {
                node.insert(Integer.parseInt(n));
            }
        }

        postOrder(node);

        bw.write(sb.toString());
        bw.flush();
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        sb.append(node.n + "\n");
    }

    static class Node {
        int n;
        Node left, right;

        public Node(int n) {
            this.n = n;
        }

        public void insert(int node) {
            if (n > node) {
                if (left == null) {
                    left = new Node(node);
                } else {
                    left.insert(node);
                }
            } else {
                if (right == null) {
                    right = new Node(node);
                } else {
                    right.insert(node);
                }
            }
        }


    }
}
