package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A); Arrays.sort(B);
        
        for (int i=0, j=0; i<A.length; i++) {
            if (A[j] < B[i]) {
                answer++;
                j++;
            }
        }
        
        return answer;
    }
}
