package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 올바른괄호 {
    public boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(') stk.push(i);
            else {
                if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else stk.push(')');
            }
        }

        return stk.isEmpty();
    }
}
