package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2482 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static long dp[][];
    private static final int MOD = 1000000003;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        dp = new long[N+1][K+1];
        for(int i=0; i<N+1; i++) Arrays.fill(dp[i], -1);

        for(int i=0; i<N+1; i++) {
            dp[i][0] = 1; dp[i][1] = i;
        }

        bw.write(findColor(N, K)+"");
    }

    private static long findColor(int n, int k) {
        if(k > n/2) {
            dp[n][k] = 0;
            return 0;
        }

        if(dp[n][k] != -1) return dp[n][k];

        return dp[n][k] = (findColor(n-1, k)+findColor(n-2, k-1))%MOD;
    }

}
