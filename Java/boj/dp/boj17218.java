package CodeTest.Java.boj.dp;

import java.io.*;

public class boj17218 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String s1 = br.readLine(), s2 = br.readLine();
        int n = s1.length(), m = s2.length();
        
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(s1.charAt(i) == s2.charAt(j)) dp[i+1][j+1] = dp[i][j]+1;
            else dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
        }

        sb = new StringBuilder();
        int cnt = dp[n][m];
        int row = n, col = m;

        while(cnt > 0) {
            if(dp[row-1][col] == cnt) row--;
            else if(dp[row][col-1] == cnt) col--;
            else {
                sb.append(s1.charAt(row-1));
                cnt--; row--; col--;
            }
        }

        bw.write(sb.reverse().toString());
    }

}
