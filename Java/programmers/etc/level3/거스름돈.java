package CodeTest.Java.programmers.etc.level3;

public class 거스름돈 {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int m : money) {
            for (int i=m; i<n+1; i++) {
                dp[i] += dp[i-m];
            }
        }
        return dp[n];
    }
}
