package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj3056 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, success[][];
    private static double dp[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        success = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                success[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new double[1<<n];

        Arrays.fill(dp, -1);

        bw.write(dfs(0,0)*100+"");
    }

    private static double dfs(int cur, int path) {
        if(cur == n) return 1;

        if(dp[path] != -1) return dp[path];

        for(int nxt=0; nxt<n; nxt++) {
            if(((path>>nxt)&1) == 0) {
                dp[path] = Math.max(dp[path], dfs(cur+1, path|(1<<nxt))*success[cur][nxt]/100);
            }
        }

        return dp[path];
    }

}
