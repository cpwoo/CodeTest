package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj7570 {
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

        int[] children = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) children[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++) dp[children[i]] = i;

        int ret = -1, cnt = 1;

        for(int i=1; i<n; i++) {
            if(dp[i] < dp[i+1]) {
                cnt++;
                if(cnt > ret) ret = cnt; 
            }
            else cnt = 1;
        }

        bw.write((ret != -1) ? n-ret+"" : "0");
    }

}
