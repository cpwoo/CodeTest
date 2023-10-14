package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 소수찾기 {
    public int solution(int n) {
        boolean[] sieve = new boolean[1000001];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        
        for (int i=2; i<1001; i++) {
            if (sieve[i]) {
                for (int j=2*i; j<1000001; j+=i) {
                    sieve[j] = false;
                }
            }
        }
        
        int answer = 0;
        for (int i=0; i<=n; i++) {
            if (sieve[i]) answer++;
        }
        
        return answer;
    }
}
