package CodeTest.Java.programmers.etc.level2;

public class 멀리뛰기 {
    public int solution(int n) {
        int MOD = 1234567;
        int[] dp = new int[2001];
        dp[1] = 1; dp[2] = 2;
        
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%MOD;
        }
        
        return dp[n];
    }   
}
