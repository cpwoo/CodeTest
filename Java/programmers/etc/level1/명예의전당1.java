package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 명예의전당1 {
        public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int s : score) {
            q.add(s);
            if (q.size() == k+1) {
                q.poll();
            }
            answer.add(q.peek());
        }
        
        return answer;
    }
}
