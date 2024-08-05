package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj3067 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

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
        int n = Integer.parseInt(br.readLine());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) coins[i] = Integer.parseInt(st.nextToken());

        int cost = Integer.parseInt(br.readLine());

        int[] dp = new int[cost+1];
        dp[0] = 1;
        for(int i=0; i<n; i++) for(int j=1; j<cost+1; j++) {
            if(j-coins[i] >= 0) {
                dp[j] += dp[j-coins[i]];
            }
        }
        
        sb.append(dp[cost]).append('\n');
    }

}
