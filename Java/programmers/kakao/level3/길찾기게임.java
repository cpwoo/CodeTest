package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 길찾기게임 {
    static int[][] answer;
    static int idx;

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        
        Node[] node = new Node[n];
        for (int i=0; i<n; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }

        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.y == n2.y) return n1.x - n2.x;
                else return n2.y - n1.y;
            }
        });

        Node root = node[0];
        for (int i=1; i<n; i++) {
            insertNode(root, node[i]);
        }

        answer = new int[2][n];
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        return answer;
    }

    private static void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    private static void preorder(Node root) {
        if (root != null) {
            answer[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.value;
        }
    }

    private class Node {
        int x, y;
        int value;
        Node left, right;

        private Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
