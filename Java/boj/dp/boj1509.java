package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1509 {
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
        String str = ' '+br.readLine();
        int L = str.length();

        int[] dp = new int[L];
        Arrays.fill(dp, 2500);
        dp[0] = 0;

        boolean[][] isP = new boolean[L][L];

        for(int i=0; i<L; i++) isP[i][i] = true;

        for(int i=1; i<L; i++) {
            if(str.charAt(i-1) == str.charAt(i)) {
                isP[i-1][i] = true;
            }
        }

        for(int j=3; j<L+1; j++) {
            for(int start=1; start<L-j+1; start++) {
                int end = start+j-1;
                if(str.charAt(start) == str.charAt(end) && isP[start+1][end-1]) {
                    isP[start][end] = true;
                }
            }
        }

        for(int end=1; end<L; end++) {
            for(int start=1; start<end+1; start++) {
                if(isP[start][end]) {
                    dp[end] = Math.min(dp[end], dp[start-1]+1);
                } else {
                    dp[end] = Math.min(dp[end], dp[end-1]+1);
                }
            }
        }

        bw.write(dp[L-1]+"");
    }

}
