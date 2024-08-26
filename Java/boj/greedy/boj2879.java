package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj2879 {
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

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] B = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) B[i] = Integer.parseInt(st.nextToken());

        int[] diff = new int[n];
        for(int i=0; i<n; i++) diff[i] = B[i]-A[i];

        int[] dp = new int[n];
        dp[0] = Math.abs(diff[0]);

        for(int i=1; i<n; i++) {
            if(diff[i]*diff[i-1] > 0) {
                dp[i] = dp[i-1]+Math.max(0, Math.abs(diff[i])-Math.abs(diff[i-1]));
            }
            else dp[i] = dp[i-1]+Math.abs(diff[i]);
        }

        bw.write(dp[n-1]+"");
    }
}
