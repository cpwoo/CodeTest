package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj1749 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            inp = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(inp[j]);
            }
        }

        int[][] dp = new int[n+1][m+1];
        int res = Integer.MIN_VALUE;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                dp[i][j] = board[i-1][j-1]+dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];

                for(int y=0; y<i; y++) {
                    for(int x=0; x<j; x++) {
                        res = Math.max(res, dp[i][j]-dp[y][j]-dp[i][x]+dp[y][x]);
                    }
                }
            }
        }

        bw.write(res+"");
    }

}
