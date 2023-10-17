package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0, total = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int e : enemy) {
            q.add(-e);
            total += e;
            if (total > n) {
                if (k == 0) break;
                total += q.poll();
                k--;
            }
            answer++;
        }
        
        return answer;
    }
}
