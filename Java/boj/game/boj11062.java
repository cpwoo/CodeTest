package CodeTest.Java.boj.game;

import java.io.*;
import java.util.*;

public class boj11062 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int cards[], dp[][];

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
        int n = Integer.parseInt(br.readLine());
        
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) cards[i] = Integer.parseInt(st.nextToken());

        dp = new int[n][n];
        
        pick(true, 0, n-1);

        sb.append(dp[0][n-1]).append('\n');
    }

    private static int pick(boolean turn, int i, int j) {
        if(i > j) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        return dp[i][j] = (turn) ? Math.max(pick(false, i+1, j)+cards[i], pick(false, i, j-1)+cards[j]) 
        : Math.min(pick(true, i+1, j), pick(true, i, j-1));
    }

}
