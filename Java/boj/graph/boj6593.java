package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj6593 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dx = {-1,1,0,0,0,0}, dy = {0,0,-1,1,0,0}, dz = {0,0,0,0,-1,1};

    private static int L, R, C, time[][][], sx, sy, sz;
    private static char m[][][];
    private static boolean visited[][][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0) break;
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        m = new char[L][R][C];
        for(int i=0; i<L; i++) {
            for(int j=0; j<R; j++) {
                m[i][j] = br.readLine().toCharArray();
            }
            br.readLine();
        }
        
        time = new int[L][R][C];
        visited = new boolean[L][R][C];

        int ex = 0, ey = 0, ez = 0;

        for(int i=0; i<L; i++) for(int j=0; j<R; j++) for(int k=0; k<C; k++) {
            if(m[i][j][k] == 'S') {
                sx = i; sy = j; sz = k;
            }
            else if(m[i][j][k] == 'E') {
                ex = i; ey = j; ez = k;
            }
        }

        bfs();

        if(time[ex][ey][ez] != 0) {
            sb.append(String.format("Escaped in %d minute(s).\n", time[ex][ey][ez]));
        }
        else {
            sb.append("Trapped!\n");
        }
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, sz});
        visited[sx][sy][sz] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = cur[2];
            for(int d=0; d<6; d++) {
                int nx = x+dx[d], ny = y+dy[d], nz = z+dz[d];
                if(0 <= nx && nx < L && 0 <= ny && ny < R && 0 <= nz && nz < C && !visited[nx][ny][nz]) {
                    if(m[nx][ny][nz] == '.' || m[nx][ny][nz] == 'E') {
                        time[nx][ny][nz] = time[x][y][z]+1;
                        q.add(new int[]{nx, ny, nz});
                        visited[nx][ny][nz] = true;
                    }
                }
            }
        }
    }

}
