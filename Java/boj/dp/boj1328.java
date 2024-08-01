package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1328 {
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
        final int MOD = 1_000_000_007;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[N+1][N+1][N+1];
        dp[1][1][1] = 1;

        for(int i=2; i<N+1; i++) {
            for(int j=1; j<L+1; j++) {
                for(int k=1; k<R+1; k++) {
                    dp[i][j][k] = (dp[i-1][j-1][k]+dp[i-1][j][k-1]+dp[i-1][j][k]*(i-2))%MOD;
                }
            }
        }

        bw.write(dp[N][L][R]+"");
    }

}
