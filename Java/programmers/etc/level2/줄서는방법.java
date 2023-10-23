package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 줄서는방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> num = new ArrayList<>();

        long f = 1;
        for (int i=1; i<=n; i++) {
            f *= i;
            num.add(i);
        }

        k--;
        int idx = 0;
        while (idx < n) {
            f /= n-idx;
            answer[idx++] = num.remove((int)(k/f));
            k %= f;
        }
        
        return answer;
    }
}
