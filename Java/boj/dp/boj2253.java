package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2253 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean[] a = new boolean[10001];
        for(int i=0; i<m; i++) {
            int x = Integer.parseInt(br.readLine());
            a[x] = true;
        }

        final int INF = 10_000_000;

        int[][] dp = new int[n+1][142];
        for(int i=0; i<n+1; i++) Arrays.fill(dp[i], INF);
        dp[1][0] = 0;

        for(int i=2; i<n+1; i++) {
            if(a[i]) continue;
            int v = 1;
            while(v*(v+1) <= 2*i) {
                dp[i][v] = Math.min(dp[i-v][v-1], Math.min(dp[i-v][v], dp[i-v][v+1]))+1;
                v++;
            }
        }

        int ret = INF;
        for(int i=0; i<142; i++) ret = Math.min(ret, dp[n][i]);

        bw.write((ret != INF) ? ret+"" : "-1");
    }

}
