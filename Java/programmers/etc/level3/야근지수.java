package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int work : works) {
            pq.add(-work);
        }
        
        while (n != 0) {
            if (pq.peek() >= 0) break;
            int a = pq.poll();
            pq.add(a+1);
            n--;
        }
        
        for (Integer a : pq) {
            answer += a*a;
        }
        
        return answer;
    }
}
