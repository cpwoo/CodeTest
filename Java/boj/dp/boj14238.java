package CodeTest.Java.boj.dp;

import java.io.*;

public class boj14238 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int n;
    private static boolean dp[][][][][];
    private static char ans[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String str = br.readLine();
        n = str.length();

        dp = new boolean[n+1][n+1][n+1][3][3];
        ans = new char[n];

        int an = 0, bn = 0, cn = 0;

        for(char s : str.toCharArray()) {
            if(s == 'A') an++;
            else if(s == 'B') bn++;
            else if(s == 'C') cn++;
        }

        bw.write((dfs(an, bn, cn, 0, 0)) ? new String(ans) : "-1");
    }

    private static boolean dfs(int a, int b, int c, int p1, int p2) {
        if(a < 0 || b < 0 || c < 0) return false;

        if(a == 0 && b == 0 && c == 0) return true;

        if(dp[a][b][c][p1][p2]) return false;

        dp[a][b][c][p1][p2] = true;

        ans[n-a-b-c] = 'A';
        if(dfs(a-1, b, c, 0, p1)) return true;

        if(p1 != 1) {
            ans[n-a-b-c] = 'B';
            if(dfs(a, b-1, c, 1, p1)) return true;
        }

        if(p1 != 2 && p2 != 2) {
            ans[n-a-b-c] = 'C';
            if(dfs(a, b, c-1, 2, p1)) return true;
        }

        return false;
    }

}
