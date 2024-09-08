package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1937 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, board[][], visited[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        visited = new int[n][n];

        int ret = 0;
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) ret = Math.max(ret, dfs(i, j));

        bw.write(ret+"");
    }

    private static int dfs(int x, int y) {
        if(visited[x][y] != 0) return visited[x][y];

        visited[x][y] = 1;

        for(int i=0; i<4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(0 <= nx && nx < n && 0 <= ny && ny < n && board[x][y] < board[nx][ny]) {
                visited[x][y] = Math.max(visited[x][y], dfs(nx, ny)+1);
            }
        }

        return visited[x][y];
    }

}
