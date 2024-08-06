package CodeTest.Java.boj.dp;

import java.io.*;

public class boj9252 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int n = A.length, m = B.length;

        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(A[i-1] == B[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        bw.write(dp[n][m]+"\n");

        int ix = n, iy = m;

        sb = new StringBuilder();
        while(true) {
            if(dp[ix][iy] == 0) break;

            if(dp[ix][iy] > dp[ix-1][iy] && dp[ix][iy] > dp[ix][iy-1]) {
                sb.append(A[ix-1]);
                ix--; iy--;
            } 
            else {
                if(dp[ix][iy] == dp[ix-1][iy]) ix--;
                else if(dp[ix][iy] == dp[ix][iy-1]) iy--;
            }
        }

        bw.write(sb.reverse().toString());
    }

}
