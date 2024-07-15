package CodeTest.Java.boj.prefixSum;

import java.io.*;
import java.util.*;

public class boj10986 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long cnt = 0;
        long[] nums = new long[n+1];
        long[] dp = new long[m];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) {
            nums[i] = (nums[i-1]+Integer.parseInt(st.nextToken()))%m;
            if(nums[i] == 0) {
                cnt++;
            }
            dp[(int)nums[i]]++;
        }

        for(int i=0; i<m; i++) {
            if(dp[i]>1) {
                cnt += dp[i]*(dp[i]-1)/2;
            }
        }

        bw.write(cnt+"");
    }

}
