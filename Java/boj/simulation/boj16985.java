package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj16985 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int INF = 987654321;
    private static final int[] dz = {1,-1,0,0,0,0}, dy = {0,0,-1,1,0,0}, dx = {0,0,0,0,1,-1};

    private static int board[][][], order[], ret, b[][][];
    private static boolean chk[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        board = new int[5][5][5];
        for(int i=0; i<5; i++) for(int j=0; j<5; j++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<5; k++) {
                board[i][j][k] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[5];
        chk = new boolean[5];

        ret = INF;

        perm(0);

        bw.write((ret != INF) ? ret+"" : "-1");
    }

    private static void perm(int idx) {
        if(idx == 5) {
            b = new int[5][5][5];
            for(int i=0; i<5; i++) b[i] = board[order[i]];
            dfs(0);
            return;
        }

        for(int i=0; i<5; i++) {
            if(!chk[i]) {
                chk[i] = true;
                order[idx] = i;
                perm(idx+1);
                chk[i] = false;
            }
        }
    }

    private static void dfs(int depth) {
        if(depth == 5) {
            if(b[0][0][0] == 1 && b[4][4][4] == 1) bfs();
            return;
        }

        for(int r=0; r<4; r++) {
            rotate(depth);
            dfs(depth+1);
        }
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});

        int[][][] dist = new int[5][5][5];
        for(int i=0; i<5; i++) for(int j=0; j<5; j++) {
            Arrays.fill(dist[i][j], INF);
        }
        dist[0][0][0] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], y = cur[1], x = cur[2];

            if(z == 4 && y == 4 && x == 4) {
                ret = Math.min(ret, dist[4][4][4]);
                return;
            }

            for(int i=0; i<6; i++) {
                int nz = z+dz[i], ny = y+dy[i], nx = x+dx[i];
                if(0 <= nz && nz < 5 && 0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                    if(b[nz][ny][nx] == 1 && dist[nz][ny][nx] == INF) {
                        dist[nz][ny][nx] = dist[z][y][x]+1;
                        q.add(new int[]{nz, ny, nx});
                    }
                }
            }
        }
    }

    private static void rotate(int d) {
        int[][] tmp = new int[5][5];
        for(int i=0; i<5; i++) for(int j=0; j<5; j++) {
            tmp[j][4-i] = b[d][i][j];
        }
        b[d] = tmp;
    }

}
