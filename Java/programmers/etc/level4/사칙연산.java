package CodeTest.Java.programmers.etc.level4;

import java.util.*;

public class 사칙연산 {
    public int solution(String[] arr) {
        int n = (arr.length+1)/2;

        int[] num = new int[n];
        char[] op = new char[n-1];

        for (int i=0; i<n; i++) num[i] = Integer.valueOf(arr[i*2]);
        for (int i=0; i<n-1; i++) op[i] = arr[i*2+1].charAt(0);

        int[][] MIN_DP = new int[n][n];
        for (int[] row : MIN_DP) Arrays.fill(row, Integer.MAX_VALUE);

        int[][] MAX_DP = new int[n][n];
        for (int[] row : MAX_DP) Arrays.fill(row, Integer.MIN_VALUE);

        for (int step=0; step<n; step++) {
            for (int i=0; i<n-step; i++) {
                int j = i+step;
                if (step == 0) {
                    MIN_DP[i][i] = num[i];
                    MAX_DP[i][i] = num[i];
                }
                else {
                    for (int k=i; k<j; k++) {
                        if (op[k] == '+') {
                            MAX_DP[i][j] = Math.max(MAX_DP[i][j], MAX_DP[i][k]+MAX_DP[k+1][j]);
                            MIN_DP[i][j] = Math.min(MIN_DP[i][j], MIN_DP[i][k]+MIN_DP[k+1][j]);
                        }
                        else {
                            MAX_DP[i][j] = Math.max(MAX_DP[i][j], MAX_DP[i][k]-MIN_DP[k+1][j]);
                            MIN_DP[i][j] = Math.min(MIN_DP[i][j], MIN_DP[i][k]-MAX_DP[k+1][j]);
                        }
                    }
                }
            }
        }

        return MAX_DP[0][n-1];
    }
}
