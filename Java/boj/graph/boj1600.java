package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1600 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    private static final int[] hx = {-2,-1,1,2,2,1,-1,-2};
    private static final int[] hy = {1,2,2,1,-1,-2,-2,-1};

    private static int k, w, h, s[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        s = new int[h][w];
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) s[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(bfs()+"");
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0, k, 0});

        boolean[][][] visited = new boolean[h][w][k+1];
        visited[0][0][k] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = cur[2], cnt = cur[3];

            if(x == h-1 && y == w-1) return cnt;

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < h && 0 <= ny && ny < w && s[nx][ny] != 1 && !visited[nx][ny][z]) {
                    visited[nx][ny][z] = true;
                    q.add(new int[]{nx, ny, z, cnt+1});
                }
            }

            if(z > 0) {
                for(int i=0; i<8; i++) {
                    int nx = x+hx[i], ny = y+hy[i];
                    if(0 <= nx && nx < h && 0 <= ny && ny < w && s[nx][ny] != 1 && !visited[nx][ny][z-1]) {
                        visited[nx][ny][z-1] = true;
                        q.add(new int[]{nx, ny, z-1, cnt+1});
                    }
                }
            }
        }

        return -1;
    }

}
