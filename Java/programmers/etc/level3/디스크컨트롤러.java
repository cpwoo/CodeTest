package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        int now = 0, i = 0;
        int start = -1;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        
        while (i < n) {
            for (int[] job : jobs) {
                if (start < job[0] && job[0] <= now) {
                    pq.add(new int[]{job[0], job[1]});
                }
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                start = now;
                now += cur[1];
                answer += now-cur[0];
                i++;
            } else {
                now++;
            }
        }
        
        return answer/n;
    }    
}
