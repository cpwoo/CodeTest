package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2624 {
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
        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        int[][] coins = new int[k+1][2];
        coins[0][0] = 0; coins[0][1] = 0;
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[k+1][t+1];
        dp[0][0] = 1;

        for(int i=1; i<k+1; i++) {
            for(int j=0; j<t+1; j++) {
                dp[i][j] = dp[i-1][j];
                for(int v=1; v<coins[i][1]+1; v++) {
                    if(j-v*coins[i][0] >= 0) {
                        dp[i][j] += dp[i-1][j-coins[i][0]];
                    }
                    else break;
                }
            }
        }

        bw.write(dp[k][t]+"");
    }

}
