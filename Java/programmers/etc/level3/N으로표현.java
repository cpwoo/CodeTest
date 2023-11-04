package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class N으로표현 {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> set = new ArrayList<>();

        for (int i=0; i<8; i++) {
            set.add(new HashSet<>());
            set.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i+1)));
        }
        
        int answer = -1;
        for (int i=1; i<8; i++) {
            for (int j=0; j<i; j++) {
                for (Integer op1 : set.get(j)) {
                    for (Integer op2 : set.get(i-j-1)) {
                        set.get(i).add(op1+op2);
                        set.get(i).add(op1-op2);
                        set.get(i).add(op1*op2);
                        if (op2 != 0) set.get(i).add(op1/op2);
                    }
                }
            }
            if (set.get(i).contains(number)) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}
