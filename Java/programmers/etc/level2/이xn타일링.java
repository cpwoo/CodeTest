package CodeTest.Java.programmers.etc.level2;

public class 이xn타일링 {
    public int solution(int n) {
        final long MOD = 1_000_000_007;
        long[] dp = new long[n+1];
        dp[1] = 1; dp[2] = 2;

        for (int i=3; i<n+1; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%MOD;
        }
        
        return (int) dp[n];
    }
}
