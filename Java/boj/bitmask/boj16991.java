package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj16991 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, points[][];
    private static double d[][], dp[][];
    private static final double INF = Integer.MAX_VALUE/2-1;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        points = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d = new double[n][n];
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                d[i][j] = d[j][i] = dist(i, j);
            }
        }

        dp = new double[n][(1<<n)];

        bw.write(dfs(0,1)+"");
    }

    private static double dist(int i, int j) {
        long dx = points[i][0]-points[j][0];
        long dy = points[i][1]-points[j][1];
        return (double) Math.sqrt(dx*dx+dy*dy);
    }

    private static double dfs(int cur, int path) {
        if(dp[cur][path] != 0) return dp[cur][path];

        if(path == ((1<<n)-1)) {
            if(d[cur][0] != 0) return d[cur][0];
            else return INF;
        }

        double cost = INF;

        for(int nxt=1; nxt<n; nxt++) {
            if(((path>>nxt)&1) == 0 && d[cur][nxt] != 0) {
                cost = Math.min(cost, d[cur][nxt]+dfs(nxt, path|(1<<nxt)));
            }
        }

        return dp[cur][path] = cost;
    }

}
