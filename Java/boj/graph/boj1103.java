package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1103 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, dp[][], ret;
    private static char arr[][];
    private static boolean visited[][], flag;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();

        dp = new int[n][m];
        visited = new boolean[n][m];

        ret = 0; flag = true;

        dfs(0, 0, 0);

        bw.write((flag) ? ret+1+"" : "-1");
    }

    private static void dfs(int x, int y, int cnt) {
        ret = Math.max(ret, cnt);
        for(int i=0; i<4; i++) {
            int nx = x+(arr[x][y]-'0')*dx[i], ny = y+(arr[x][y]-'0')*dy[i];
            if(0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] != 'H' && cnt+1 > dp[nx][ny]) {
                if(visited[nx][ny]) {
                    flag = false;
                    return;
                }
                dp[nx][ny] = cnt+1;
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                visited[nx][ny] = false;
            }
        }
    }

}
