package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int s : scoville) q.add(s);

        while (q.peek() < K) {
            if (q.size() <= 1) return -1;
            int a = q.poll(), b = q.poll();
            q.add(a+b*2);
            answer++;
        }
        
        return answer;
    }
}
