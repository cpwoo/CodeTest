package CodeTest.Java.boj.bitmask;

import java.io.*;

public class boj1562 {
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
        int n = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;

        long[][][] dp = new long[n+1][10][1024];

        for(int i=1; i<10; i++) {
            dp[1][i][1<<i] = 1;
        }

        for(int i=2; i<n+1; i++) {
            for(int j=0; j<10; j++) {
                for(int k=1; k<1024; k++) {
                    int nxt = k|(1<<j);
                    if(j == 0) {
                        dp[i][j][nxt] += dp[i-1][1][k];
                    } else if(j == 9) {
                        dp[i][j][nxt] += dp[i-1][8][k];
                    } else {
                        dp[i][j][nxt] += (dp[i-1][j-1][k]+dp[i-1][j+1][k])%mod;
                    }
                    dp[i][j][nxt] %= mod;
                }
            }
        }

        long ret = 0;
        for(int i=0; i<10; i++) {
            ret += dp[n][i][1023];
            ret %= mod;
        }

        bw.write(ret+"");
    }

}
