package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int n = elements.length;
        HashSet<Integer> answer = new HashSet<>();
        
        for (int i=0; i<n; i++) {
            int tmp = elements[i];
            answer.add(tmp);
            for (int j=i+1; j<i+n; j++) {
                tmp += elements[j%n];
                answer.add(tmp);
            }
        }
        
        return answer.size();
    }
}
