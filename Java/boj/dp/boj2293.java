package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2293 {
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
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for(int i=0; i<n; i++) coin[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int c: coin) {
            for(int i=1; i<k+1; i++) {
                if(i-c >= 0) {
                    dp[i] += dp[i-c];
                }
            }
        }

        bw.write(dp[k]+"");
    }

}
