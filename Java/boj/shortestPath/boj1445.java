package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1445 {
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

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) board[i] = br.readLine().toCharArray();
        
        int sx = 0, sy = 0, fx = 0, fy = 0;

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 'S') {
                sx = i; sy = j;
            }
            else if(board[i][j] == 'F') {
                fx = i; fy = j;
            }
            else if(board[i][j] == 'g') {
                for(int d=0; d<4; d++) {
                    int ni = i+dx[d], nj = j+dy[d];
                    if(0 <= ni && ni < n && 0 <= nj && nj < m && board[ni][nj] == '.') board[ni][nj] = 'p';
                }
            }
        }

        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i=0; i<3; i++) if(o1[i] != o2[i]) return o1[i]-o2[i];
                return o1[3]-o2[3];
            }
        });

        q.add(new int[]{0, 0, sx, sy});

        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dist[i], -1);

        dist[sx][sy] = 0;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int g = tmp[0], p = tmp[1], x = tmp[2], y = tmp[3];

            if(x == fx && y == fy) {
                bw.write(g+" "+p+"");
                return;
            }

            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && dist[nx][ny] == -1) {
                    if(board[nx][ny] == 'g') q.add(new int[]{g+1, p, nx, ny});

                    else if(board[nx][ny] == 'p') q.add(new int[]{g, p+1, nx, ny});
                    
                    else q.add(new int[]{g, p, nx, ny});

                    dist[nx][ny] = dist[x][y]+1;
                }
            }
        }
    }

}
