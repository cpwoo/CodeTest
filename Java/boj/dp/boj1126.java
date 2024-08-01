package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1126 {
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
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[500001];
        int rb = 1;

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int a: arr) {
            rb += a;
            int[] nxt = Arrays.copyOf(dp, 500001);
            for(int i=0; i<rb; i++) {
                if(dp[i] != 0) {
                    int neg = Math.abs(i-a);
                    nxt[i+a] = Math.max(nxt[i+a], dp[i]+a);
                    nxt[neg] = Math.max(nxt[neg], Math.max(dp[i], dp[i]-i+a));
                }
            }
            for(int i=0; i<rb; i++) {
                dp[i] = Math.max(dp[i], nxt[i]);
            }
            dp[a] = Math.max(dp[a], a);
        }

        bw.write((dp[0] == 0) ? "-1" : dp[0]+"");
    }

}
