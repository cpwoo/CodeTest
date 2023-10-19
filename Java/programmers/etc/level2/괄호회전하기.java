package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        answer += check(s);
        
        for (int i=0; i<s.length()-1; i++) {
            s = s.substring(1) + s.substring(0, 1);
            answer += check(s);
        }
        
        return answer;
    }
    
    private int check(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (Character q : s.toCharArray()) {
            if (stk.isEmpty()) {
                stk.push(q);
            } else {
                char p = stk.peek();
                if ((p=='('&&q==')') || (p=='{'&&q=='}') || (p=='['&&q==']')) stk.pop();
                else stk.push(q);
            }
        }

        return stk.isEmpty() ? 1 : 0;
    }
}
