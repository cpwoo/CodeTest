package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj12869 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[][] perm = {{1,3,9},{1,9,3},{3,1,9},{3,9,1},{9,1,3},{9,3,1}};

    private static int ret, dp[][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int[] a = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, a[i]);
        }

        ret = 100;
        dp = new int[max+1][max+1][max+1];

        dfs(a[0], a[1], a[2], 0);

        bw.write(ret+"");
    }

    private static void dfs(int x, int y, int z, int cnt) {
        if(x <= 0 && y <= 0 && z <= 0) {
            if(ret > cnt) ret = cnt;
            return;
        }

        x = (x <= 0) ? 0 : x;
        y = (y <= 0) ? 0 : y;
        z = (z <= 0) ? 0 : z;

        if(dp[x][y][z] <= cnt && dp[x][y][z] != 0) return;

        dp[x][y][z] = cnt;

        for(int i=0; i<6; i++) {
            dfs(x-perm[i][0], y-perm[i][1], z-perm[i][2], cnt+1);
        }
    }
}
