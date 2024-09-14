package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj11967 {
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

        List<int[]> graph[][] = new ArrayList[n][n];
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            graph[i][j] = new ArrayList<>();
        } 

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a-1][b-1].add(new int[]{c-1, d-1});
        }

        boolean[][] visited = new boolean[n][n];
        boolean[][] on = new boolean[n][n];

        visited[0][0] = on[0][0] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        int cnt = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int[] nxt : graph[x][y]) {
                int nx = nxt[0], ny = nxt[1];
                if(!on[nx][ny]) {
                    on[nx][ny] = true;
                    cnt++;
                    for(int d=0; d<4; d++) {
                        int nnx = nx+dx[d], nny = ny+dy[d];
                        if(0 <= nnx && nnx < n && 0 <= nny && nny < n && visited[nnx][nny]) {
                            q.add(new int[]{nnx, nny});
                        }
                    }
                }
            }
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && on[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        bw.write(cnt+"");
    }
}
