package programmers.길찾기게임;

import java.util.*;

class Solution {
    static int preorderIdx = 0;
    static int postorderIdx = 0;

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodeArr = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            nodeArr[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodeArr, (o1, o2) -> o2.y - o1.y);


        Node rootNode = nodeArr[0];
        System.out.println(rootNode.number);
        for(int i = 1; i < nodeArr.length; i++){
            insertNode(rootNode, nodeArr[i]);
        }

        int[][] result = new int[2][nodeArr.length];
        preorder(rootNode, result[0]);
        postorder(rootNode, result[1]);

        return result;
    }

    static void preorder(Node node, int[] result){
        result[preorderIdx++] = node.number;
        if(node.leftChild != null){
            preorder(node.leftChild, result);
        }

        if(node.rightChild != null){
            preorder(node.rightChild, result);
        }

    }

    static void postorder(Node node, int[] result){
        if(node.leftChild != null){
            postorder(node.leftChild, result);
        }

        if(node.rightChild != null){
            postorder(node.rightChild, result);
        }
        result[postorderIdx++] = node.number;
    }

    static void insertNode(Node parent, Node child){
        // 왼쪽 자식
        if(parent.x > child.x){
            if(parent.leftChild == null){
                parent.leftChild = child;
            }else insertNode(parent.leftChild, child);
        }

        // 오른쪽 자식
        else{
            if(parent.rightChild == null){
                parent.rightChild = child;
            }else{
                insertNode(parent.rightChild, child);
            }
        }
    }
    static class Node{
        int number;
        int x;
        int y;
        Node leftChild;
        Node rightChild;

        public Node(int number, int x, int y){
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
}
