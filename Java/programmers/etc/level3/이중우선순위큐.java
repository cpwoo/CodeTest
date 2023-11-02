package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        PriorityQueue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] cmd = operation.split(" ");
            int num = Integer.parseInt(cmd[1]);
            
            if (cmd[0].equals("I")) {
                min_q.add(num);
                max_q.add(num);
            } else {
                if (!min_q.isEmpty()) {
                    if (num == 1) {
                        int _max = max_q.poll();
                        min_q.remove(_max);
                    } else {
                        int _min = min_q.poll();
                        max_q.remove(_min);
                    }
                }
            }
        }
        
        return min_q.isEmpty() ? new int[]{0, 0} : new int[]{max_q.peek(), min_q.peek()};
    }
}
