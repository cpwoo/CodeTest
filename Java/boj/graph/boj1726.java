package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1726 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,0,0,1,-1}, dy = {0,1,-1,0,0};

    private static int m, n, board[][], sx, sy, sd, ex, ey, ed;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        sd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        ed = Integer.parseInt(st.nextToken());

        bw.write(bfs()+"");
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx-1, sy-1, sd, 0});

        boolean[][][] visited = new boolean[m][n][5];
        visited[sx-1][sy-1][sd] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2], cnt = cur[3];

            if(x == ex-1 && y == ey-1 && d == ed) return cnt;

            int nx = x, ny = y;

            for(int i=0; i<3; i++) {
                nx += dx[d]; ny += dy[d];
                if(0 <= nx && nx < m && 0 <= ny && ny < n && visited[nx][ny][d]) continue;
                if(0 <= nx && nx < m && 0 <= ny && ny < n && board[nx][ny] != 1) {
                    visited[nx][ny][d] = true;
                    q.add(new int[]{nx, ny, d, cnt+1});
                }
                else break;
            }

            for(int i=1; i<5; i++) {
                if(d != i && !visited[x][y][i]) {
                    visited[x][y][i] = true;
                    if((d == 1 && i == 2) || (d == 2 && i == 1) || (d == 3 && i == 4) || (d == 4 && i == 3)) {
                        q.add(new int[]{x, y, i, cnt+2});
                    }
                    else q.add(new int[]{x, y, i, cnt+1});
                }
            }
        }

        return -1;
    }

}
