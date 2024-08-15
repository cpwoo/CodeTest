package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj13144 {
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
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[] dp = new boolean[100001];
        int end = 0;
        long cnt = 0;

        for(int i=0; i<n; i++) {
            while(end < n) {
                if(dp[arr[end]]) break;
                dp[arr[end]] = true;
                end++;
            }
            cnt += end-i;
            dp[arr[i]] = false;
        }

        bw.write(cnt+"");
    }

}
