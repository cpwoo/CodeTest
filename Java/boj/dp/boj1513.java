package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1513 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int MOD = 1_000_007;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] a = new int[n+1][m+1];
        int[][][][] dp = new int[n+1][m+1][c+1][c+1];

        dp[1][1][0][0] = 1;
        for(int i=1; i<c+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 1 && y == 1) {
                dp[1][1][0][0] = 0;
                dp[1][1][i][1] = 1;
            }
            a[x][y] = i;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(i == 1 && j == 1) continue;
                if(a[i][j] > 0) {
                    for(int l=0; l<a[i][j]; l++) {
                        for(int k=0; k<l+1; k++) {
                            dp[i][j][a[i][j]][k+1] += dp[i-1][j][l][k]+dp[i][j-1][l][k];
                            dp[i][j][a[i][j]][k+1] %= MOD;
                        }
                    }
                }
                else {
                    for(int l=0; l<c+1; l++) {
                        for(int k=0; k<l+1; k++) {
                            dp[i][j][l][k] = dp[i-1][j][l][k]+dp[i][j-1][l][k];
                            dp[i][j][l][k] %= MOD;
                        }
                    }
                }
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<c+1; i++) {
            int tmp = 0;
            for(int j=0; j<c+1; j++) {
                tmp = (tmp+dp[n][m][j][i])%MOD;
            }
            sb.append(tmp).append(' ');
        }

        bw.write(sb.toString());
    }

}
