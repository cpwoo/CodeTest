package CodeTest.Java.boj.dp;

import java.io.*;

public class boj2602 {
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
        String target = br.readLine();
        String first = br.readLine();
        String second = br.readLine();

        int T = target.length(), L = first.length();

        int[][][] dp = new int[L][T][2];

        for(int i=0; i<L; i++) {
            if(first.charAt(i) == target.charAt(0)) dp[i][0][0] = 1;
            if(second.charAt(i) == target.charAt(0)) dp[i][0][1] = 1;
        }

        for(int i=0; i<L; i++) {
            for(int j=1; j<T; j++) {
                if(first.charAt(i) == target.charAt(j)) {
                    for(int k=0; k<i; k++) {
                        dp[i][j][0] += dp[k][j-1][1];
                    }
                }
                if(second.charAt(i) == target.charAt(j)) {
                    for(int k=0; k<i; k++) {
                        dp[i][j][1] += dp[k][j-1][0];
                    }
                }
            }
        }

        int ret = 0;
        for(int i=0; i<L; i++) ret += dp[i][T-1][0]+dp[i][T-1][1];

        bw.write(ret+"");
    }

}
