package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj10942 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][n];

        for(int idx=0; idx<n; idx++) for(int start=0; start<n; start++) {
            int end = start+idx;

            if(end >= n) break;

            if(idx == 0) {
                dp[start][end] = 1;
                continue;
            }

            if(idx == 1) {
                if(arr[start] == arr[end]) {
                    dp[start][end] = 1;
                    continue;
                }
            }

            if(arr[start] == arr[end] && dp[start+1][end-1] == 1) {
                dp[start][end] = 1;
            }
        }


        int m = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start-1][end-1]).append('\n');
        }

        bw.write(sb.toString());
    }

}
