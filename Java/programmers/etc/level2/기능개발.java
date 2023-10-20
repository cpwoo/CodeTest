package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 기능개발 {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            q.add((int) (Math.ceil((100.0-progresses[i])/speeds[i])));
        }

        List<Integer> answer = new ArrayList<>();

        while (!q.isEmpty()) {
            int day = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && day >= q.peek()) {
                cnt++;
                q.poll();
            }
            answer.add(cnt);
        }

        return answer;
    }
}
