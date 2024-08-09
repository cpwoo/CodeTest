package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj15486 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        for(int i=0; i<n; i++) {
            if(i+t[i] <= n) dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        bw.write(dp[n]+"");
    }

}
