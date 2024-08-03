package CodeTest.Java.boj.dp;

import java.io.*;

public class boj1670 {
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
        long[] dp = new long[10001];
        dp[0] = 1; dp[2] = 1;

        int i = 4;
        while(i <= n) {
            long tmp = 0;
            for(int j=0; j<=i-2; j+=2) {
                tmp += (dp[j]*dp[i-j-2])%987654321;
            }
            dp[i] = tmp%987654321;
            i += 2;
        }

        bw.write(dp[n]+"");
    }

}
