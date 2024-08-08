package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj13392 {
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
        
        int[] a = new int[n];
        String inp = br.readLine();
        for(int i=0; i<n; i++) a[i] = inp.charAt(i)-'0';

        int[] b = new int[n];
        inp = br.readLine();
        for(int i=0; i<n; i++) b[i] = inp.charAt(i)-'0';

        int[][] dp = new int[n+1][10];
        for(int i=0; i<n+1; i++) Arrays.fill(dp[i], 987654321);

        for(int i=0; i<10; i++) dp[0][i] = i;

        for(int i=1; i<n+1; i++) {
            for(int j=0; j<10; j++) {
                int lcnt = (b[i-1]-a[i-1]-j+20)%10;
                int rcnt = 10-lcnt;
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+rcnt);
                dp[i][(j+lcnt)%10] = Math.min(dp[i][(j+lcnt)%10], dp[i-1][j]+lcnt);
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int i=0; i<10; i++) ret = Math.min(ret, dp[n][i]);

        bw.write(ret+"");
    }

}
