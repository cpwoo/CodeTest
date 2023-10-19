package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 삼각달팽이 {
    static List<Integer> answer;
    static int[][] m;
    static int cnt;
    
    public List<Integer> solution(int n) {
        answer = new ArrayList<>();
        m = new int[n][n];
        cnt = 0;
        fill(0, 0, n);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (m[i][j] != 0) answer.add(m[i][j]);
            }
        }
        return answer;
    }
    
    private static void fill(int y, int x, int sz) {
        if (sz <= 0) return;
        if (sz == 1) {
            cnt++;
            m[y][x] = cnt;
            return;
        }
        
        for (int i=0; i<sz; i++) {
            cnt++;
            m[y+i][x] = cnt;
        }
        
        for (int i=1; i<sz; i++) {
            cnt++;
            m[y+sz-1][x+i] = cnt;
        }
        
        for (int i=1; i<sz-1; i++) {
            cnt++;
            m[y+sz-i-1][x+sz-i-1] = cnt;
        }
        
        fill(y+2, x+1, sz-3);
    }
}
