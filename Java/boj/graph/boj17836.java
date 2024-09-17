package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj17836 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, graph[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = bfs();

        bw.write((ret <= t) ? ret+"" : "Fail");
    }

    private static int bfs() {
        int gram = 10001;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        int[][] visited = new int[n][m];
        visited[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            if(x == n-1 && y == m-1) return Math.min(visited[x][y]-1, gram);

            if(graph[x][y] == 2) gram = (visited[x][y]-1)+(n-1-x)+(m-1-y);

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] == 0) {
                    if(graph[nx][ny] == 0 || graph[nx][ny] == 2) {
                        visited[nx][ny] = visited[x][y]+1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return gram;
    }

}
