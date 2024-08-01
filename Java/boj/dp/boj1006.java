package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1006 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n, w, up[], down[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        up = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) up[i] = Integer.parseInt(st.nextToken());

        down = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) down[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][3];
        dp[0][0] = 0; dp[0][1] = 1; dp[0][2] = 1;
        dp = recur(0, dp);
        int res = dp[n][0];

        if(n > 1 && up[0]+up[n-1] <= w) {
            dp[1][0] = 1; dp[1][1] = 2;
            dp[1][2] = (down[0]+down[1] <= w) ? 1 : 2;
            dp = recur(1, dp);
            res = Math.min(res, dp[n-1][2]+1);
        }

        if(n > 1 && down[0]+down[n-1] <= w) {
            dp[1][0] = 1; dp[1][2] = 2;
            dp[1][1] = (up[0]+up[1] <= w) ? 1 : 2;
            dp = recur(1, dp);
            res = Math.min(res, dp[n-1][1]+1);
        }

        if(n > 1 && up[0]+up[n-1] <= w && down[0]+down[n-1] <= w) {
            dp[1][0] = 0; dp[1][1] = 1; dp[1][2] = 1;
            dp = recur(1, dp);
            res = Math.min(res, dp[n-1][0]+2);
        }

        sb.append(res).append('\n');
    }

    private static int[][] recur(int start, int[][] dp) {
        for(int i=start; i<n; i++) {
            dp[i+1][0] = Math.min(dp[i][1]+1, dp[i][2]+1);
            if(up[i]+down[i] <= w) {
                dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0]+1);
            }
            if(i > 0 && up[i-1]+up[i] <= w && down[i-1]+down[i] <= w) {
                dp[i+1][0] = Math.min(dp[i+1][0], dp[i-1][0]+2);
            }
            if(i < n-1) {
                dp[i+1][1] = dp[i+1][0]+1;
                if(up[i+1]+up[i] <= w) dp[i+1][1] = Math.min(dp[i+1][1], dp[i][2]+1);
                
                dp[i+1][2] = dp[i+1][0]+1;
                if(down[i+1]+down[i] <= w) dp[i+1][2] = Math.min(dp[i+1][2], dp[i][1]+1);
            }
        }

        return dp;
    }

}
