package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj2616 {
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
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        String[] inp = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        int k = Integer.parseInt(br.readLine());

        int[] s = new int[n+1];
        for(int i=1; i<n+1; i++) {
            s[i] = s[i-1]+arr[i-1];
        }

        int[][] dp = new int[3][n+1];
        for(int i=0; i<3; i++) {
            for(int j=(i+1)*k; j<n+1; j++) {
                if(i == 0) {
                    dp[i][j] = Math.max(dp[i][j-1], s[j]-s[j-k]);
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k]+s[j]-s[j-k]);
                }
            }
        }

        bw.write(dp[2][n]+"");
    }

}
