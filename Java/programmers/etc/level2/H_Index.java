package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= citations.length-i) {
                answer++;
            }
        }
        
        return answer;
    }
}
