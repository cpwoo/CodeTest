package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj13460 {
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

        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) board[i] = br.readLine().toCharArray();

        int rx = 0, ry = 0, bx = 0, by = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 'R') {
                rx = i; ry = j;
            }
            else if(board[i][j] == 'B') {
                bx = i; by = j;
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{rx, ry, bx, by, 1});

        boolean[][][][] visited = new boolean[n][m][n][m];
        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0], cry = cur[1], cbx = cur[2], cby = cur[3], depth = cur[4];

            if(depth > 10) break;

            for(int i=0; i<4; i++) {
                int nrx = crx, nry = cry, rcnt = 0;
                while(board[nrx+dx[i]][nry+dy[i]] != '#' && board[nrx][nry] != 'O') {
                    nrx += dx[i]; nry += dy[i]; rcnt++;
                }

                int nbx = cbx, nby = cby, bcnt = 0;
                while(board[nbx+dx[i]][nby+dy[i]] != '#' && board[nbx][nby] != 'O') {
                    nbx += dx[i]; nby += dy[i]; bcnt++;
                }

                if(board[nbx][nby] != 'O') {
                    if(board[nrx][nry] == 'O') {
                        bw.write(depth+"");
                        return;
                    }
                    if(nrx == nbx && nry == nby) {
                        if(rcnt > bcnt) {
                            nrx -= dx[i]; nry -= dy[i];
                        }
                        else {
                            nbx -= dx[i]; nby -= dy[i];
                        }
                    }
                    if(!visited[nrx][nry][nbx][nby]) {
                        visited[nrx][nry][nbx][nby] = true;
                        q.add(new int[]{nrx, nry, nbx, nby, depth+1});
                    }
                }
            }
        }

        bw.write("-1");
    }

}
