package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 스타수열 {
    public int solution(int[] a) {
        int n = a.length;
        
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> chk = new HashMap<>();
        for (int i=0; i<n; i++) {
            cnt.put(i, 0);
            chk.put(i, -2);
        }

        for (int i=0; i<n-1; i++) {
            if (a[i] != a[i+1]) {
                if (chk.get(a[i]) != i-1) {
                    cnt.put(a[i], cnt.get(a[i])+1);
                    chk.put(a[i], i);
                }
                if (chk.get(a[i+1]) != i-1) {
                    cnt.put(a[i+1], cnt.get(a[i+1])+1);
                    chk.put(a[i+1], i);
                }
            }
        }

        int _max = 0;
        for (int value : cnt.values()) {
            _max = Math.max(_max, value);
        }

        return _max*2;
    }
}
