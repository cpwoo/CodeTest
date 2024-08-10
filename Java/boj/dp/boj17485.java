package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj17485 {
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

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m][3];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            Arrays.fill(dp[i][j], 100*1000+1);
        }

        for(int y=0; y<n; y++) {
            if(y == 0) {
                for(int x=0; x<m; x++) for(int d=0; d<3; d++) {
                    dp[y][x][d] = board[y][x];
                }
            }
            else {
                for(int x=0; x<m; x++) {
                    if(x == 0) {
                        dp[y][x][0] = Math.min(dp[y-1][x+1][1], dp[y-1][x+1][2])+board[y][x];
                        dp[y][x][1] = dp[y-1][x][0]+board[y][x];
                    }
                    else if(x == m-1) {
                        dp[y][x][1] = dp[y-1][x][2]+board[y][x];
                        dp[y][x][2] = Math.min(dp[y-1][x-1][0], dp[y-1][x-1][1])+board[y][x];
                    }
                    else {
                        dp[y][x][0] = Math.min(dp[y-1][x+1][1], dp[y-1][x+1][2])+board[y][x];
                        dp[y][x][1] = Math.min(dp[y-1][x][0], dp[y-1][x][2])+board[y][x];
                        dp[y][x][2] = Math.min(dp[y-1][x-1][0], dp[y-1][x-1][1])+board[y][x];
                    }
                }
            }
        }

        int ret = 987654321;
        for(int x=0; x<m; x++) for(int d=0; d<3; d++) {
            ret = Math.min(ret, dp[n-1][x][d]);
        }

        bw.write(ret+"");
    }

}
