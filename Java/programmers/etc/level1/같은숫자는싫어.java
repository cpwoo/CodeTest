package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 같은숫자는싫어 {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        
        for (int i=1; i<arr.length; i++) {
            if (stk.peek() != arr[i]) stk.push(arr[i]);
        }
        
        return stk;
    }
}
