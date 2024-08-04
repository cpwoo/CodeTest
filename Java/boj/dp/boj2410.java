package CodeTest.Java.boj.dp;

import java.io.*;

public class boj2410 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int MOD = 1000000000;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;
        
        int[] nums = new int[21];
        for(int i=0; i<21; i++) nums[i] = 1<<i;

        for(int num : nums) {
            if(num <= n) {
                for(int i=num; i<n+1; i++) {
                    dp[i] = (dp[i]+dp[i-num])%MOD;
                }
            }
        }

        bw.write(dp[n]+"");
    }

}
