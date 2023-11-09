package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

class Node {
    HashMap<Character, Node> childNode = new HashMap<>();
    int maxDepth = 0;

    Node put(char c) {
        maxDepth++;
        if (!childNode.containsKey(c)) childNode.put(c, new Node());
        return childNode.get(c);
    }
}

public class 자동완성 {
    static Node root = new Node();

    public int solution(String[] words) {
        for (String word : words) insert(word);

        return cal(root, 0);
    }

    private static void insert(String word) {
        Node curNode = root;
        
        for (char c : word.toCharArray()) {
            Node nxtNode = curNode.put(c);
            curNode = nxtNode;
        }

        curNode.put('-');
    }

    private static int cal(Node root, int depth) {
        if (root.maxDepth == 1) return depth;
        
        int cnt = 0;
        for (char key : root.childNode.keySet()) {
            cnt += (key == '-') ? depth : cal(root.childNode.get(key), depth+1);
        }
        
        return cnt;
    }
}
