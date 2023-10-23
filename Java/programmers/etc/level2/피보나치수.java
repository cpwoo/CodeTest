package CodeTest.Java.programmers.etc.level2;

public class 피보나치수 {
    public int solution(int n) {
        int MOD = 1234567;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<n+1; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%MOD;
        }
        return dp[n];
    }
}
