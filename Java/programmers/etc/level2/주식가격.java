package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stk = new Stack<>();

        for (int i=0; i<prices.length; i++) {
            if (!stk.isEmpty()) {
                while (!stk.isEmpty() && stk.peek()[1] > prices[i]) {
                    int[] cur = stk.pop();
                    int past = cur[0];
                    answer[past] = i-past;
                }
            }
            stk.push(new int[]{i, prices[i]});
        }

        for (int[] st : stk) {
            answer[st[0]] = prices.length-1-st[0];
        }

        return answer;
    }
}
