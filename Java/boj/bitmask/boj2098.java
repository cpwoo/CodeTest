package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj2098 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, board[][], dp[][];
    private static final int INF = Integer.MAX_VALUE/2-1;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][(1<<n)-1];

        bw.write(dfs(0,0)+"");
    }

    private static int dfs(int i, int route) {
        if(dp[i][route] != 0) return dp[i][route];

        if(route == (1<<(n-1))-1) {
            if(board[i][0] != 0) return board[i][0];
            else return INF;
        }

        int bound = INF;

        for(int j=1; j<n; j++) {
            if(board[i][j] == 0) continue;
            if((route&(1<<(j-1))) != 0) continue;
            bound = Math.min(bound, board[i][j]+dfs(j, route|(1<<(j-1))));
        }

        return dp[i][route] = bound;
    }

}
