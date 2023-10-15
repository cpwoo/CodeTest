package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                answer[stk.pop()] = numbers[i];
            }
            stk.add(i);
        }
        
        return answer;
    }
}
