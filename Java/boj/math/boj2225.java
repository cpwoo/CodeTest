package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj2225 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int mod = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];

        for(int i=0; i<n+1; i++) dp[i][1] = 1;
        for(int i=0; i<k+1; i++) dp[1][i] = i;

        for(int i=2; i<n+1; i++) for(int j=2; j<k+1; j++) {
            dp[i][j] = (dp[i-1][j]+dp[i][j-1])%mod;
        }

        bw.write(dp[n][k]+"");
    }

}
