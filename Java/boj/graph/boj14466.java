package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14466 {
    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int N;
    private static Set<Pos> graph[][];
    private static boolean visited[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new HashSet[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            graph[i][j] = new HashSet<>();
        }

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;
            graph[r1][c1].add(new Pos(r2, c2));
            graph[r2][c2].add(new Pos(r1, c1));
        }

        int[][] cows = new int[K][2];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                cows[i][j] = Integer.parseInt(st.nextToken())-1;
            }
        }

        int cnt = 0;
        for(int i=0; i<K; i++) {
            visited = new boolean[N][N];
            bfs(cows[i][0], cows[i][1]);
            for(int j=i+1; j<K; j++) {
                if(!visited[cows[j][0]][cows[j][1]]) cnt++;
            }
        }

        bw.write(cnt+"");
    }

    private static void bfs(int r, int c) {
        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(r, c));
        visited[r][c] = true;

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            for(int d=0; d<4; d++) {
                int nx = pos.x+dx[d], ny = pos.y+dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    Pos nPos = new Pos(nx, ny);
                    if(!graph[pos.x][pos.y].contains(nPos)) {
                        q.add(nPos);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}
