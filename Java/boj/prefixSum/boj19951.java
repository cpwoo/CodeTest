package CodeTest.Java.boj.prefixSum;

import java.io.*;
import java.util.*;

public class boj19951 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dp[a-1] += k;
            dp[b] -= k;
        }

        int idx = 0, cur = dp[0];
        while(++idx < n) {
            dp[idx] += cur;
            cur = dp[idx];
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(arr[i]+dp[i]).append(' ');

        bw.write(sb.toString());
    }

}
