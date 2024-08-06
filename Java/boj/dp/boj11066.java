package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj11066 {
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
        int K = Integer.parseInt(br.readLine());
        
        int[] arr = new int[K+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<K+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][K+1];
        for(int i=1; i<K+1; i++) for(int j=1; j<K+1; j++) {
            if(j == i+1) dp[i][j] = arr[i]+arr[j];
        }

        for(int i=K-1; i>0; i--) for(int j=i+1; j<K+1; j++) {
            if(dp[i][j] == 0) {
                int min = Integer.MAX_VALUE;
                for(int p=i; p<j; p++) min = Math.min(min, dp[i][p]+dp[p+1][j]);
                int sum = 0;
                for(int p=i; p<j+1; p++) sum += arr[p];
                dp[i][j] = min+sum;
            }
        }

        sb.append(dp[1][K]).append('\n');
    }

}
