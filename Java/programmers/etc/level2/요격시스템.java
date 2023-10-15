package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {return o1[1]-o2[1];});
        int prev_e = 0;
        
        for (int i=0; i<targets.length; i++) {
            if (targets[i][0] >= prev_e) {
                prev_e = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}
