package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1577 {
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

        long[][] dp = new long[n+1][m+1];

        boolean[][][] v = new boolean[n+1][m+1][2];

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(a == c) v[a][Math.min(b, d)][0] = true;
            else v[Math.min(a, c)][b][1] = true;
        }

        for(int i=1; i<m+1; i++) {
            if(v[0][i-1][0]) break;
            dp[0][i] = 1;
        }

        for(int i=1; i<n+1; i++) {
            if(v[i-1][0][1]) break;
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(!v[i-1][j][1]) dp[i][j] += dp[i-1][j];
                if(!v[i][j-1][0]) dp[i][j] += dp[i][j-1];
            }
        }

        bw.write(dp[n][m]+"");
    }

}
