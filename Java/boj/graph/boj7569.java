package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj7569 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0,0,0}, dy = {0,0,-1,1,0,0}, dz = {0,0,0,0,-1,1};

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
        int h = Integer.parseInt(st.nextToken());

        int[][][] matrix = new int[h][n][m];
        Deque<int[]> q = new ArrayDeque<>();

        for(int i=0; i<h; i++) for(int j=0; j<n; j++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++) {
                matrix[i][j][k] = Integer.parseInt(st.nextToken());
                if(matrix[i][j][k] == 1) {
                    q.add(new int[]{i, j, k});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], x = cur[1], y = cur[2];
            for(int i=0; i<6; i++) {
                int nz = z+dz[i], nx = x+dx[i], ny = y+dy[i];
                if(0 <= nz && nz < h && 0 <= nx && nx < n && 0 <= ny && ny < m && matrix[nz][nx][ny] == 0) {
                    q.add(new int[]{nz, nx, ny});
                    matrix[nz][nx][ny] = matrix[z][x][y]+1;
                }
            }
        }

        int ret = 0;
        for(int i=0; i<h; i++) for(int j=0; j<n; j++) for(int k=0; k<m; k++) {
            if(matrix[i][j][k] == 0) {
                bw.write("-1");
                return;
            }
            ret = Math.max(ret, matrix[i][j][k]);
        }

        bw.write(ret-1+"");
    }

}
