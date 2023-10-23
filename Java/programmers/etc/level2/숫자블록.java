package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 숫자블록 {
    public int[] solution(long begin, long end) {
        int first = (int) begin;
        int last = (int) end;
        int sz = last-first+1;
        int[] answer = new int[sz];
        
        for (int i=first; i<=last; i++) {
            answer[i-first] = maxdivisor(i);
        }

        return answer;
    }

    private static int maxdivisor(int n) {
        if (n == 1) return 0;
        List<Integer> divisors = new ArrayList<>();
        for (int x=1; x<(int)Math.sqrt(n)+1; x++) {
            if (n%x == 0) {
                if (x <= 10_000_000) {
                    divisors.add(x);
                }
                if (n/x <= 10_000_000 && n/x != n) {
                    divisors.add(n/x);
                }
            }
        }
        return Collections.max(divisors);
    }
}
