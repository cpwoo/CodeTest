package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj21922 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][m];

        Deque<int[]> q = new ArrayDeque<>();

        int[][] board = new int[n][m];

        for(int r=0; r<n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if(board[r][c] == 9) {
                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = dx[d], ny = dy[d];
                int r = x+nx, c = y+ny;
                
                while(0 <= r && r < n && 0 <= c && c < m) {
                    visited[r][c] = true;
                    
                    if(board[r][c] == 9) break;

                    if(board[r][c] == 3) {
                        int tmp = nx;
                        nx = -ny;
                        ny = -tmp;
                    }
                    else if(board[r][c] == 4) {
                        int tmp = nx;
                        nx = ny;
                        ny = tmp;
                    }
                    else if((board[r][c] == 1 && nx == 0) || (board[r][c] == 2 && ny == 0)) {
                        break;
                    }
                    r += nx; c += ny;
                }
            }
        }

        int ret = 0;
        for(int r=0; r<n; r++) for(int c=0; c<m; c++) {
            ret += (visited[r][c]) ? 1 : 0;
        }
        bw.write(ret+"");
    }

}
