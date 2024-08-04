package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2306 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static String str;
    private static int dp[][];
    private static final int INF = 10000000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        str = br.readLine();
        int n = str.length();
        dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], INF);

        bw.write(n-dfs(0,n-1)+"");
    }

    private static int dfs(int x, int y) {
        if(x > y) return 0;

        if(x == y) return 1;

        if(dp[x][y] != INF) return dp[x][y];

        char p = str.charAt(x);
        char q = str.charAt(y);
        if((p == 'a' && q == 't') || (p == 'g' && q == 'c')) {
            dp[x][y] = Math.min(dp[x][y], dfs(x+1, y-1));
        }

        for(int k=x; k<y; k++) {
            dp[x][y] = Math.min(dp[x][y], dfs(x, k)+dfs(k+1, y));
        }

        return dp[x][y];
    }

}
