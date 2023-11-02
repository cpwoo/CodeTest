package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1,o2)->o1[1]-o2[1]);
        int end = -30001;
        
        for (int[] route : routes) {
            int s = route[0], e = route[1];
            if (end < s) {
                end = e;
                answer++;
            }
        }
        
        return answer;
    }
}
