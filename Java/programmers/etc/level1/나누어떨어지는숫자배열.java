package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 나누어떨어지는숫자배열 {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);
        
        for (int a : arr) {
            if (a%divisor == 0) answer.add(a);
        }
        
        return answer.isEmpty() ? List.of(-1) : answer;
    }
}
