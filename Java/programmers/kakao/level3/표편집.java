package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 표편집 {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeArr = new Node[n];
        for (int i=0; i<n; i++) {
            nodeArr[i] = new Node(false, null, null);
        }

        for (int i=1; i<n; i++) {
            nodeArr[i-1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i-1];
        }

        Node cur = nodeArr[k];
        Stack<Node> stk = new Stack<>();

        for (String st : cmd) {
            char p = st.charAt(0);
            if (p == 'U') {
                int x = Integer.parseInt(st.substring(2));
                for (int i=0; i<x; i++) cur = cur.prev;
            } 
            else if (p == 'D') {
                int x = Integer.parseInt(st.substring(2));
                for (int i=0; i<x; i++) cur = cur.next;
            }
            else if (p == 'C') {
                stk.push(cur);
                cur.removed = true;
                Node up = cur.prev, down = cur.next;
                if (up != null) {
                    up.next = down;
                }
                if (down != null) {
                    down.prev = up;
                    cur = down;
                } else {
                    cur = up;
                }
            }
            else if (p == 'Z') {
                Node node = stk.pop();
                node.removed = false;
                Node up = node.prev, down = node.next;
                if (up != null) {
                    up.next = node;
                }
                if (down != null) {
                    down.prev = node;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (nodeArr[i].removed) answer.append("X");
            else answer.append("O");
        }

        return answer.toString();
    }

    private class Node {
        boolean removed;
        Node prev, next;
        
        Node(boolean removed, Node prev, Node next) {
            this.removed = removed;
            this.prev = prev;
            this.next = next;
        }
    }
}
