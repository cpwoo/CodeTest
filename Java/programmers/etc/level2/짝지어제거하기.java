package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (char i : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == i) stk.pop();
            else stk.push(i);
        }
        
        return stk.isEmpty() ? 1 : 0;
    }
}
