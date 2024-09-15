package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16929 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    private static int N, M;
    private static char[][] board;
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for(int i=0; i<N; i++) board[i] = br.readLine().toCharArray();

        visited = new boolean[N][M];
        flag = false;
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            if(!visited[i][j]) dfs(i, j, -1, -1);
        }

        bw.write((flag) ? "Yes" : "No");
    }

    private static void dfs(int r, int c, int sr, int sc) {
        if(visited[r][c]) {
            flag = true;
            return;
        }

        visited[r][c] = true;
        
        for(int d=0; d<4; d++) {
            int nr = r+dr[d], nc = c+dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != board[r][c]) continue;

            if(nr == sr && nc == sc) continue;

            dfs(nr, nc, r, c);
        }
    }

}
