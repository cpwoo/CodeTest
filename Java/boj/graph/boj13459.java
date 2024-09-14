package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj13459 {
    static class Pos {
        int rx, ry, bx, by;
        Pos(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return rx == pos.rx && ry == pos.ry && bx == pos.bx && by == pos.by;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rx, ry, bx, by);
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static char[][] graph;

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

        graph = new char[n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for(int i=0; i<n; i++) {
            graph[i] = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 'R') {
                    rx = i; ry = j;
                }
                else if(graph[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        bw.write((bfs(rx, ry, bx, by)) ? "1" : "0");
    }

    private static boolean bfs(int rx, int ry, int bx, int by) {
        Pos pos = new Pos(rx, ry, bx, by);

        Deque<Pos> q = new ArrayDeque<>();
        q.add(pos);

        Set<Pos> visited = new HashSet<>();
        visited.add(pos);

        int cnt = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0; i<sz; i++) {
                pos = q.poll();

                if(cnt > 10) return false;

                if(graph[pos.rx][pos.ry] == 'O') return true;

                for(int d=0; d<4; d++) {
                    int nrx = pos.rx, nry = pos.ry;
                    while(true) {
                        nrx += dx[d];
                        nry += dy[d];
                        if(graph[nrx][nry] == '#') {
                            nrx -= dx[d];
                            nry -= dy[d];
                            break;
                        }
                        if(graph[nrx][nry] == 'O') break;
                    }

                    int nbx = pos.bx, nby = pos.by;
                    while(true) {
                        nbx += dx[d];
                        nby += dy[d];
                        if(graph[nbx][nby] == '#') {
                            nbx -= dx[d];
                            nby -= dy[d];
                            break;
                        }
                        if(graph[nbx][nby] == 'O') break;
                    }

                    if(graph[nbx][nby] == 'O') continue;

                    if(nrx == nbx && nry == nby) {
                        if(Math.abs(nrx-pos.rx)+Math.abs(nry-pos.ry) > Math.abs(nbx-pos.bx)+Math.abs(nby-pos.by)) {
                            nrx -= dx[d];
                            nry -= dy[d];
                        }
                        else {
                            nbx -= dx[d];
                            nby -= dy[d];
                        }
                    }

                    Pos nPos = new Pos(nrx, nry, nbx, nby);

                    if(!visited.contains(nPos)) {
                        q.add(nPos);
                        visited.add(nPos);
                    }
                }
            }
            cnt++;
        }
        
        return false;
    }

}
