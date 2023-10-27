package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 최적의행렬곱셈 {
    public int solution(int[][] m) {
        int n = m.length;
        int[][] dp = new int[n][n];
        
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        for (int i=0; i<n; i++) {
            dp[i][i] = 0;
        }
        
        for (int gap=1; gap<n; gap++) {
            for (int start=0; start<n; start++) {
                int end = start+gap;
                if (end >= n) break;
                for (int sep=start; sep<end; sep++) {
                    int value = dp[start][sep]+dp[sep+1][end]+(m[start][0]*m[sep][1]*m[end][1]);
                    dp[start][end] = Math.min(dp[start][end], value);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
