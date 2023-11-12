package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 숫자타자대회 {
    private static final int[][] cost = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };

    private static int[][][] dp;
    private static int len;

    public int solution(String numbers) {
        len = numbers.length();

        dp = new int[len+1][10][10];
        for (int i=0; i<len+1; i++) {
            for (int j=0; j<10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(numbers, 0, 4, 6);
    }

    private static int solve(String numbers, int idx, int L, int R) {
        if (idx == len) return 0;
        if (dp[idx][L][R] != -1) return dp[idx][L][R];

        int num = numbers.charAt(idx)-'0';
        int result = Integer.MAX_VALUE;

        if (num != R) result = Math.min(result, solve(numbers,idx+1,num,R)+cost[L][num]);
        if (num != L) result = Math.min(result, solve(numbers,idx+1,L,num)+cost[R][num]);

        dp[idx][L][R] = result;
        
        return result;
    }
}
