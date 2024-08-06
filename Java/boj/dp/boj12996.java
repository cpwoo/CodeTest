package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj12996 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int MOD = 1_000_000_007;
    private static long dp[][][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        dp = new long[51][51][51][51];
        for(int i=0; i<51; i++) for(int j=0; j<51; j++) for(int k=0; k<51; k++) {
            Arrays.fill(dp[i][j][k], -1);
        }

        bw.write(dfs(s, a, b, c)+"");
    }

    private static long dfs(int s, int a, int b, int c) {
        if(s == 0) {
            if(a != 0 || b != 0 || c != 0) return 0;
            else return 1;
        }
        
        if(a < 0 || b < 0 || c < 0) return 0;
        
        if(dp[s][a][b][c] != -1) return dp[s][a][b][c];

        dp[s][a][b][c] = 0;
        for(int i=0; i<2; i++) for(int j=0; j<2; j++) for(int k=0; k<2; k++) {
            if(i+j+k == 0) continue;
            dp[s][a][b][c] += dfs(s-1, a-i, b-j, c-k);
        }

        return dp[s][a][b][c] %= MOD;
    }

}
