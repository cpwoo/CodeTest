package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16973 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, h, w, fr, fc;
    private static List<int[]> walls;
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        walls = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    walls.add(new int[]{i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];

        bw.write(bfs(sr-1, sc-1)+"");
    }

    private static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 0});

        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0]; y = cur[1]; 
            int cnt = cur[2];

            if(x == fr-1 && y == fc-1) return cnt;

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n-h+1 && 0 <= ny && ny < m-w+1 && !visited[nx][ny] && chk(nx, ny)) {
                    q.add(new int[]{nx, ny, cnt+1});
                }
            }
        }

        return -1;
    }

    private static boolean chk(int x, int y) {
        visited[x][y] = true;
        for(int[] wall : walls) {
            int i = wall[0], j = wall[1];
            if(x <= i && i < x+h && y <= j && j < y+w) return false;
        }
        return true;
    }

}
