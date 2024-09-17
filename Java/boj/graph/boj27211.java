package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj27211 {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 1) visited[i][j] = -1;
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        int cnt = 1;

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(visited[i][j] == 0) {
                q.add(new int[]{i, j});
                visited[i][j] = cnt;

                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    
                    for(int d=0; d<4; d++) {
                        int nx = (x+dx[d]+n)%n, ny = (y+dy[d]+m)%m;
                        if(visited[nx][ny] == 0) {
                            visited[nx][ny] = cnt;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                cnt++;
            }
        }

        int ret = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            ret = Math.max(ret, visited[i][j]);
        }

        bw.write(ret+"");
    }

}
