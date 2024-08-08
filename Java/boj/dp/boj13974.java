package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj13974 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            v = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) v[i] = Integer.parseInt(st.nextToken());

            solve(n);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve(int n) throws Exception {
        int[] s = new int[n+1];
        for(int i=1; i<n+1; i++) s[i] = s[i-1]+v[i-1];

        int[][] dp = new int[n+1][n+1];
        int[][] K = new int[n+1][n+1];
        for(int i=1; i<n+1; i++) {
            dp[i-1][i] = 0; K[i-1][i] = i;
        }

        for(int m=2; m<n+1; m++) {
            for(int i=0; i<n-m+1; i++) {
                int j = i+m;
                dp[i][j] = 987654321;
                for(int k=K[i][j-1]; k<K[i+1][j]+1; k++) {
                    int now = dp[i][k]+dp[k][j]+s[j]-s[i];
                    if(now < dp[i][j]) {
                        dp[i][j] = now;
                        K[i][j] = k;
                    }
                }
            }
        }

        sb.append(dp[0][n]).append('\n');
    }

}
