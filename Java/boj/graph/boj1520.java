package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1520 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    private static int m, n, arr[][], dp[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);

        bw.write(dfs(0, 0)+"");
    }

    private static int dfs(int x, int y) {
        if(x == m-1 && y == n-1) return 1;

        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for(int i=0; i<4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                if(arr[nx][ny] < arr[x][y]) dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }

}
