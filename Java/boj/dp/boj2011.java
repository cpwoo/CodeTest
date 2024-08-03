package CodeTest.Java.boj.dp;

import java.io.*;

public class boj2011 {
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
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        if(str.charAt(0) == '0') bw.write("0");
        else {
            for(int i=2; i<n+1; i++) {
                int p = str.charAt(i-2)-'0';
                int q = str.charAt(i-1)-'0';

                if(q > 0) dp[i] += dp[i-1];
                if(10 <= 10*p+q && 10*p+q <= 26) dp[i] += dp[i-2];

                dp[i] %= 1000000;
            }

            bw.write(dp[n]+"");
        }
    }

}
