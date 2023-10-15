package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 호텔대실 {
    public int solution(String[][] book_time) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {return o1[0]-o2[0];});
        for (String[] book : book_time) {
            String s = book[0], e = book[1];
            q.add(new int[]{calc(s), calc(e)});
        }
        PriorityQueue<Integer> last = new PriorityQueue<>();
        last.add(10);
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_s = cur[0], cur_e = cur[1];
            if (cur_s >= last.peek()+10) {
                last.poll();
            }
            last.add(cur_e);
        }
        return last.size();
    }
    
    private int calc(String str) {
        String[] st = str.split(":");
        return Integer.parseInt(st[0])*60 + Integer.parseInt(st[1]);
    }
}
