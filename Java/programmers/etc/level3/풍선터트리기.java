package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 풍선터트리기 {
    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        int n = a.length;
        
        int _min = a[0];
        for (int i=0; i<n; i++) {
            _min = Math.min(_min, a[i]);
            set.add(_min);
        }

        _min = a[n-1];
        for (int i=n-1; i>=0; i--) {
            _min = Math.min(_min, a[i]);
            set.add(_min);
        }

        return set.size();
    }
}
