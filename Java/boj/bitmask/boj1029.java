package CodeTest.Java.boj.bitmask;

import java.io.*;

public class boj1029 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static String inp[];

    private static int n, board[][], dp[][][];

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
            inp = br.readLine().split("");
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(inp[j]);
            }
        }

        dp = new int[n][1<<n][10];

        bw.write(1+dfs(0,1,0)+"");
    }

    private static int dfs(int cur, int path, int price) {
        if(dp[cur][path][price] != 0) return dp[cur][path][price];

        int cnt = 0;
        for(int nxt=1; nxt<n; nxt++) {
            if(board[cur][nxt] < price || (path&(1<<nxt)) != 0) continue;
            cnt = Math.max(cnt, 1+dfs(nxt, path|(1<<nxt), board[cur][nxt]));
        }

        dp[cur][path][price] = cnt;

        return cnt;
    }

}
