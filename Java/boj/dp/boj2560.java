package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2560 {
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
        final int MOD = 1000;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        dp[0] = 1;

        for(int i=1; i<N+1; i++) {
            if(i < a) dp[i] = dp[i-1];
            else if(i < b) dp[i] = (dp[i-1]+dp[i-a])%MOD;
            else dp[i] = (dp[i-1]+dp[i-a]-dp[i-b]+MOD)%MOD;
        }

        bw.write((d > N) ? dp[N]%MOD+"" : (dp[N]-dp[N-d]+MOD)%MOD+"");
    }

}
