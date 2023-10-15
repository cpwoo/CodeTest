package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 과제진행하기 {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        int pos = 0;

        Map<Integer, String> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o1[1]-o2[1];});

        Stack<int[]> stk = new Stack<>();

        for (int i=0; i<n; i++) {
            map.put(i, plans[i][0]);
            pq.add(new int[]{i, calc(plans[i][1]), Integer.parseInt(plans[i][2])});
        }

        int[] start = pq.poll();
        int idx = start[0], time = start[1], remain = start[2];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (time+remain > cur[1]) {
                stk.add(new int[]{idx, time+remain-cur[1]});
            } else if (time+remain == cur[1]) {
                answer[pos++] = map.get(idx);
            } else {
                answer[pos++] = map.get(idx);
                int r_time = cur[1]-(time+remain);
                while (!stk.isEmpty()) {
                    int[] r = stk.pop();
                    if (r[1] <= r_time) {
                        answer[pos++] = map.get(r[0]);
                        r_time -= r[1];
                        if (r_time == 0) {
                            break;
                        } 
                    } else {
                        stk.add(new int[]{r[0], r[1]-r_time});
                        break;
                    }
                }
            }
            idx = cur[0]; time = cur[1]; remain = cur[2];
        }

        answer[pos++] = map.get(idx);
        while (!stk.isEmpty()) {
            int[] r = stk.pop();
            answer[pos++] = map.get(r[0]);
        }

        return answer;
    }

    private int calc(String str) {
        String[] st = str.split(":");
        return Integer.parseInt(st[0])*60 + Integer.parseInt(st[1]);
    }
}
