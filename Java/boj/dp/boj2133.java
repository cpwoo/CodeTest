package CodeTest.Java.boj.dp;

import java.io.*;

public class boj2133 {
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
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[31];
        dp[2] = 3;

        for(int i=4; i<n+1; i+=2) {
            long sum = 0;
            for(int j=0; j<i-2; j+=2) sum += dp[j];
            dp[i] = dp[i-2]*3 + sum*2 + 2;
        }

        bw.write(dp[n]+"");
    }

}
