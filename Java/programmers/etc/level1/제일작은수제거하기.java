package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 제일작은수제거하기 {
    public List<Integer> solution(int[] arr) {
        int n = arr.length;
        
        int idx = 0;
        for (int i=0; i<n-1; i++) {
            if (arr[idx] > arr[i+1]) {
                idx = i+1;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (i != idx) {
                answer.add(arr[i]);
            }
        }
        
        return answer.size() == 0 ? List.of(-1) : answer;
    }
}
