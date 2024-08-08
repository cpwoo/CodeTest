package CodeTest.Java.boj.dp;

import java.io.*;

public class boj14517 {
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
        final int max = 1010, mod = 10007;

        String str = br.readLine();
        int n = str.length();

        int[][] dp = new int[max][max];

        for(int i=0; i<n; i++) dp[i][i] = 1;

        for(int i=0; i<n-1; i++) {
            dp[i][i+1] = str.charAt(i) == str.charAt(i+1) ? 3 : 2; 
        }

        for(int L=2; L<n; L++) {
            for(int left=0; left<n; left++) {
                int right = left+L;
                if(right > n-1) break;

                dp[left][right] = dp[left+1][right]+dp[left][right-1]-dp[left+1][right-1]+mod;

                if(str.charAt(left) == str.charAt(right)) {
                    dp[left][right] += dp[left+1][right-1]+1;
                }

                dp[left][right] %= mod;
            }
        }

        bw.write(dp[0][n-1]+"");
    }

}
