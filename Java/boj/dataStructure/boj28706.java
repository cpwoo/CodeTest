package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj28706 {
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
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] dp = new boolean[n+1][7];
            dp[0][1] = true;
            for(int i=1; i<n+1; i++) {
                st = new StringTokenizer(br.readLine());
                char op1 = st.nextToken().charAt(0);
                int v1 = Integer.parseInt(st.nextToken());
                char op2 = st.nextToken().charAt(0);
                int v2 = Integer.parseInt(st.nextToken());
                for(int j=0; j<7; j++) {
                    if(dp[i-1][j]) {
                        if(op1 == '+') dp[i][(v1+j)%7] = true;
                        else dp[i][(v1*j)%7] = true;
                        if(op2 == '+') dp[i][(v2+j)%7] = true;
                        else dp[i][(v2*j)%7] = true;
                    }
                }
            }

            bw.write(dp[n][0] ? "LUCKY\n" : "UNLUCKY\n");
        }   
    }

}
