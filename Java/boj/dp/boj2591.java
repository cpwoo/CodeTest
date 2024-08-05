package CodeTest.Java.boj.dp;

import java.io.*;

public class boj2591 {
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
        String str = br.readLine();
        int n = str.length();

        int[][] dp = new int[n][2];
        dp[0][0] = 1; dp[0][1] = 0;

        for(int i=1; i<n; i++)  {
            int a = str.charAt(i-1)-'0';
            int b = str.charAt(i)-'0';
            if(10 <= 10*a+b && 10*a+b <= 34) {
                dp[i][1] = dp[i-1][0];
            }
            if(b == 0) continue;
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
        }

        bw.write(dp[n-1][0]+dp[n-1][1]+"");
    }

}
