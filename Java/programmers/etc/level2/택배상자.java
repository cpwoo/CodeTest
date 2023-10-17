package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 택배상자 {
    public int solution(int[] order) {
        int cnt = 0;
        Stack<Integer> stk = new Stack<>();
        
        for (int i=1; i<order.length+1; i++) {
            stk.push(i);
            while (!stk.isEmpty() && stk.peek() == order[cnt]) {
                cnt++;
                stk.pop();
            }
        }
        
        return cnt;
    }
}
