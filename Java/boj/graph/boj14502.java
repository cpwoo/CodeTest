package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14502 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, matrix[][], ret;
    private static Deque<int[]> q;

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

        matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = 0;
        q = new ArrayDeque<>();

        wall(0);

        bw.write(ret+"");
    }

    private static void wall(int x) {
        if(x == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(matrix[i][j] == 0) {
                matrix[i][j] = 1;
                wall(x+1);
                matrix[i][j] = 0;
            }
        }
    }

    private static void bfs() {
        int[][] w = new int[n][m];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            w[i][j] = matrix[i][j];
            if(w[i][j] == 2) {
                q.add(new int[]{i, j});
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && w[nx][ny] == 0) {
                    w[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(w[i][j] == 0) cnt++;
        }

        ret = Math.max(ret, cnt);
    }

}
