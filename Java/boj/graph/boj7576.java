package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj7576 {
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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && matrix[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    matrix[nx][ny] = matrix[x][y]+1;
                }
            }
        }

        int ret = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(matrix[i][j] == 0) {
                bw.write("-1");
                return;
            }
            ret = Math.max(ret, matrix[i][j]);
        }

        bw.write(ret-1+"");
    }

}
