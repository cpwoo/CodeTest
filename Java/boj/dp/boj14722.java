package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj14722 {
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
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[n][n];

        if(board[0][0] == 0) dp[0][0] = 1;

        for(int i=1; i<n; i++) {
            int tmp = dp[i-1][0];
            dp[i][0] = (board[i][0] == tmp%3) ? tmp+1 : tmp;
        }

        for(int j=1; j<n; j++) {
            int tmp = dp[0][j-1];
            dp[0][j] = (board[0][j] == tmp%3) ? tmp+1 : tmp;
        }

        for(int i=1; i<n; i++) for(int j=1; j<n; j++) {
            int tmp = Math.max(dp[i-1][j], dp[i][j-1]);
            dp[i][j] = (board[i][j] == tmp%3) ? tmp+1 : tmp;
        }

        bw.write(dp[n-1][n-1]+"");
    }

}
