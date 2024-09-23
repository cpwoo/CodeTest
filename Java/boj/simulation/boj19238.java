package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj19238 {
    static class Info implements Comparable<Info> {
        int sx, sy, ex, ey, d;
        Info(int sx, int sy, int ex, int ey) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
            this.d = 0;
        }

        @Override
        public int compareTo(Info o) {
            if(this.d != o.d) return o.d-this.d;
            else if(this.sx != o.sx) return o.sx-this.sx;
            else if(this.sy != o.sy) return o.sy-this.sy;
            else if(this.ex != o.ex) return this.ex-o.ex;
            return this.ey-o.ey;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, graph[][], visited[][];
    private static Stack<Info> stk;

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
        int fuel = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        stk = new Stack<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            stk.add(new Info(sx, sy, ex, ey));
        }

        while(!stk.isEmpty()) {
            visited = new int[n][n];
            bfs(x-1, y-1);
            dist();
            Info info = stk.pop();

            visited = new int[n][n];
            bfs(info.sx-1, info.sy-1);
            int dist = visited[info.ex-1][info.ey-1];
            x = info.ex; y = info.ey;

            if(info.d == -1 || dist == -1) {
                bw.write("-1");
                return;
            }

            fuel -= info.d;
            if(fuel < 0) break;

            fuel -= dist;
            if(fuel < 0) break;

            fuel += dist*2;
        }

        bw.write((fuel >= 0) ? fuel+"" : "-1");
    }

    private static void bfs(int x, int y) {
        for(int i=0; i<n; i++) Arrays.fill(visited[i], -1);
        visited[x][y] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int tx = cur[0], ty = cur[1];
            for(int i=0; i<4; i++) {
                int nx = tx+dx[i], ny = ty+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && graph[nx][ny] != 1 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[tx][ty]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void dist() {
        for(int i=0; i<stk.size(); i++) {
            Info info = stk.get(i);
            info.d = visited[info.sx-1][info.sy-1];
        }

        Collections.sort(stk);
    }

}
