package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            String st = cur.word; int cnt = cur.edge;
            if (st.equals(target)) return cnt;
            for (int i=0; i<n; i++) {
                if (!visited[i] && check(st, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], cnt+1));
                }
            }
        }
        
        return 0;
    }
    
    private static boolean check(String s1, String s2) {
        int cnt = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
    
    class Node {
        String word;
        int edge;
        
        Node(String word, int edge) {
            this.word = word;
            this.edge = edge;
        }
    }
}
