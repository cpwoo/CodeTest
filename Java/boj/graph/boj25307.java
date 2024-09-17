package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj25307 {
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
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(visited[i], -1);

        Deque<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 3) {
                q.add(new int[]{i, j});
                visited[i][j] = 0;
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(visited[x][y] < k && visited[nx][ny] == -1) {
                        if(board[nx][ny] != 4) board[nx][ny] = 3;
                        visited[nx][ny] = visited[x][y]+1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        for(int i=0; i<n; i++) Arrays.fill(visited[i], -1);

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 4) {
                q.add(new int[]{i, j});
                visited[i][j] = 0;
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if((board[nx][ny] == 0 || board[nx][ny] == 2) && visited[nx][ny] == -1) {
                        visited[nx][ny] = visited[x][y]+1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int ret = -1;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 2 && visited[i][j] != -1) {
                if(ret == -1 || ret > visited[i][j]) {
                    ret = visited[i][j];
                }
            }
        }

        bw.write(ret+"");
    }

}
