package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1234 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int fact[], n, r, g, b;
    private static long dp[][][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        fact = new int[11];
        fact[0] = 1;
        for(int i=1; i<11; i++) fact[i] = fact[i-1]*i;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dp = new long[n+1][r+1][g+1][b+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<r+1; j++) {
                for(int k=0; k<g+1; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        bw.write(dfs(1, 0, 0, 0)+"");
    }

    private static long dfs(int lv, int rn, int gn, int bn) {
        if(lv > n) return 1;

        if(dp[lv][rn][gn][bn] != -1) return dp[lv][rn][gn][bn];

        long ret = 0;

        if(r-rn >= lv) ret += dfs(lv+1, rn+lv, gn, bn);
        if(g-gn >= lv) ret += dfs(lv+1, rn, gn+lv, bn);
        if(b-bn >= lv) ret += dfs(lv+1, rn, gn, bn+lv);

        if(lv%2 == 0) {
            if(r-rn >= lv/2 && g-gn >= lv/2) {
                ret += combi(lv, lv/2, lv/2, 0)*dfs(lv+1, rn+lv/2, gn+lv/2, bn);
            }
            if(g-gn >= lv/2 && b-bn >= lv/2) {
                ret += combi(lv, 0, lv/2, lv/2)*dfs(lv+1, rn, gn+lv/2, bn+lv/2);
            }
            if(r-rn >= lv/2 && b-bn >= lv/2) {
                ret += combi(lv, lv/2, 0, lv/2)*dfs(lv+1, rn+lv/2, gn, bn+lv/2);
            }
        }
        
        if(lv%3 == 0) {
            if(r-rn >= lv/3 && g-gn >= lv/3 && b-bn >= lv/3) {
                ret += combi(lv, lv/3, lv/3, lv/3)*dfs(lv+1, rn+lv/3, gn+lv/3, bn+lv/3);
            }
        }

        return dp[lv][rn][gn][bn] = ret;
    }

    private static int combi(int idx, int x, int y, int z) {
        return fact[idx]/(fact[x]*fact[y]*fact[z]);
    }

}
