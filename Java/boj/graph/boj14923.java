package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14923 {
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

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken())-1;
        int Hy = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken())-1;
        int Ey = Integer.parseInt(st.nextToken())-1;

        boolean[][] board = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = (st.nextToken().charAt(0) == '1');
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{Hx, Hy, 0});

        int[][][] visited = new int[n][m][2];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            Arrays.fill(visited[i][j], -1);
        }
        visited[Hx][Hy][0] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], state = cur[2];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(!board[nx][ny] && visited[nx][ny][state] == -1) {
                        visited[nx][ny][state] = visited[x][y][state]+1;
                        q.add(new int[]{nx, ny, state});
                    }
                    if(board[nx][ny] && state == 0 && visited[nx][ny][state+1] == -1) {
                        visited[nx][ny][state+1] = visited[x][y][state]+1;
                        q.add(new int[]{nx, ny, state+1});
                    }
                }
            }
        }

        bw.write(Math.min(visited[Ex][Ey][0], visited[Ex][Ey][1])+"");
    }

}
