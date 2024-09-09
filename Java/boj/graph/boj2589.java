package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2589 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m;
    private static char board[][];

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

        board = new char[n][m];
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 'L') max = Math.max(max, bfs(i, j));
        }

        bw.write(max+"");
    }

    private static int bfs(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        int[][] visited = new int[n][m];
        visited[i][j] = 1;

        int cnt = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 'L' && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y]+1;
                    cnt = Math.max(cnt, visited[nx][ny]);
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return cnt-1;
    }

}
