package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 큰수만들기 {
    public String solution(String number, int k) {
        Stack<Character> tmp = new Stack<>();

        for (char num : number.toCharArray()) {
            while (k>0 && !tmp.isEmpty() && tmp.peek() < num) {
                tmp.pop();
                k--;
            }
            tmp.push(num);
        }

        String answer = "";

        for (int i=0; i<tmp.size()-k; i++) {
            answer += tmp.get(i);
        }

        return answer;
    }
}
