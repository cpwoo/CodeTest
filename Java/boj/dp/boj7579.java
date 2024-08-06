package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj7579 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) memories[i] = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int tc = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            tc += cost[i];
        }

        long[][] dp = new long[N][tc];

        int ret = tc;

        for(int i=0; i<N; i++) for(int j=0; j<tc; j++) {
            if(cost[i] > j) dp[i][j] = (i>0) ? dp[i-1][j] : 0;
            else dp[i][j] = (i>0) ? Math.max(dp[i-1][j], memories[i]+dp[i-1][j-cost[i]]) : memories[i];
            
            if(dp[i][j] >= M) ret = Math.min(ret, j);
        }

        if(M == 0 || tc == 0) bw.write(0+"");
        else if(N == 1) bw.write(cost[0]+"");
        else if(ret == tc) bw.write(N*M+"");
        else bw.write(ret+"");
    }

}
