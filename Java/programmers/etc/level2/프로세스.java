package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<priorities.length; i++) {
            q.add(priorities[i]);
        }

        while (!q.isEmpty()) {
            for (int i=0; i<priorities.length; i++) {
                if (priorities[i] == q.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    q.poll();
                    answer++;
                }
            }
        }

        return -1;
    }
}
