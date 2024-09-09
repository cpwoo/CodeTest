package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2234 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    
    private static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0}, dir = {1,2,4,8};

    private static int n, m, board[][], visited[][];
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

        board = new int[m][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        visited = new int[m][n];

        q = new ArrayDeque<>();

        int cnt = 1;
        for(int i=0; i<m; i++) for(int j=0; j<n; j++) {
            if(visited[i][j] == 0) bfs(i, j, cnt++);
        }

        bw.write(cnt-1+"\n");

        int[] ans = new int[cnt-1];

        for(int i=0; i<m; i++) for(int j=0; j<n; j++) {
            ans[visited[i][j]-1]++;
        }

        int max = 0;
        for(int i=0; i<cnt-1; i++) max = Math.max(max, ans[i]);

        bw.write(max+"\n");

        int maxRoom = 0;
        for(int i=0; i<m; i++) for(int j=0; j<n; j++) for(int k=0; k<4; k++) {
            int ni = i+dx[k], nj = j+dy[k];
            if(0 <= ni && ni < m && 0 <= nj && nj < n) {
                if(visited[i][j] != visited[ni][nj]) {
                    int room = ans[visited[i][j]-1]+ans[visited[ni][nj]-1];
                    maxRoom = Math.max(maxRoom, room);
                }
            }
        }

        bw.write(maxRoom+"");
    }

    private static void bfs(int x, int y, int cnt) {
        q.add(new int[]{x, y});
        visited[x][y] = cnt;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0]; y = cur[1];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if((dir[i] & ~board[nx][ny]) != 0 && visited[nx][ny] == 0) {
                        visited[nx][ny] = cnt;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}
