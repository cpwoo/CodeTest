package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Stack<Integer> sec = new Stack<>();
        
        for (int s : section) {
            sec.push(s);
        }
        
        while (!sec.isEmpty()) {
            int end = sec.pop();
            while (!sec.isEmpty() && sec.peek() > end-m) {
                sec.pop();
            }
            answer++;
        }
        
        return answer;
    }
}
