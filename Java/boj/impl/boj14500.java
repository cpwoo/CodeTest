package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj14500 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    private static int N, M, board[][], ret;
    private static boolean check[][];

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

        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[N][M];
        
        ret = 0;
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            check[i][j] = true;
            dfs(i, j, board[i][j], 1);
            check[i][j] = false;
            ret = Math.max(ret, block(i, j));
        }

        bw.write(ret+"");
    }

    private static void dfs(int x, int y, int val, int depth) {
        if(depth == 4) {
            ret = Math.max(ret, val);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                if(!check[nx][ny]) {
                    check[nx][ny] = true;
                    dfs(nx, ny, val+board[nx][ny], depth+1);
                    check[nx][ny] = false;
                }
            }
        }
    }

    private static int block(int x, int y) {
        int tmp = board[x][y], wings = 4, min = Integer.MAX_VALUE;

        for(int i=0; i<4; i++) {
            int nx  = x+dx[i], ny = y+dy[i];

            if(wings == 2) return 0;

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                wings--;
                continue;
            }

            tmp += board[nx][ny];
            min = Math.min(min, board[nx][ny]);
        }

        if(wings == 4) tmp -= min;

        return tmp;
    }

}
