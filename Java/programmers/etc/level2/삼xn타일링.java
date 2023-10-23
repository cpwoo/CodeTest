package CodeTest.Java.programmers.etc.level2;

public class 삼xn타일링 {
    public int solution(int n) {
        final long MOD = 1_000_000_007;
        long[] dp = new long[n+1];
        dp[2] = 3;
        long total = 0;
        for (int i=4; i<=n; i+=2) {
            dp[i] = (3*dp[i-2]+(2*total+2))%MOD;
            total += dp[i-2]%MOD;
        }
        return (int) dp[n];
    }
}
