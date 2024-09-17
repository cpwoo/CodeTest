package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj18428 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n;
    private static char[][] board;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        bw.write((dfs(0)) ? "YES" : "NO");
    }

    private static boolean dfs(int count) {
        if(count == 3) {
            boolean flag = true;
            for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
                if(board[i][j] == 'T') {
                    flag &= chk(i, j);
                }
            }
            return flag;
        }

        boolean ret = false;

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(board[i][j] == 'X') {
                board[i][j] = 'O';
                ret |= dfs(count+1);
                board[i][j] = 'X';
            }
        }

        return ret;
    }

    private static boolean chk(int x, int y) {
        for(int k=0; k<4; k++) {
            int nx = x+dx[k], ny = y+dy[k];
            while(0 <= nx && nx < n && 0 <= ny && ny < n) {
                if(board[nx][ny] == 'X') {
                    nx += dx[k]; ny += dy[k];
                }
                else if(board[nx][ny] == 'S') return false;
                else break;
            }
        }
        return true;
    }

}
