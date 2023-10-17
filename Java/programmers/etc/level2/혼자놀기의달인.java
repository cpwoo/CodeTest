package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 혼자놀기의달인 {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> answer = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            int now = i;
            int cnt = 0;
            while (!visited[now]) {
                cnt++;
                visited[now] = true;
                now = cards[now]-1;
            }
            answer.add(cnt);
        }
        answer.sort((o1,o2)->{return o2-o1;});
        return answer.size() == 1 ? 0 : answer.get(0)*answer.get(1);
    }
}
