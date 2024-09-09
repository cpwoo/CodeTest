package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2146 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, arr[][], cnt, ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        cnt = 2;
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(dfs(i, j)) cnt++;
        }

        ret = Integer.MAX_VALUE;
        for(int i=2; i<cnt; i++) bfs(i);

        bw.write(ret+"");
    }

    private static boolean dfs(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n) return false;

        if(arr[x][y] == 1) {
            arr[x][y] = cnt;
            for(int d=0; d<4; d++) {
                dfs(x+dx[d], y+dy[d]);
            }
            return true;
        }

        return false;
    }

    private static void bfs(int p) {
        int[][] chk = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(chk[i], -1);

        Deque<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(arr[i][j] == p) {
                q.add(new int[]{i, j});
                chk[i][j] = 0;
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                if(arr[nx][ny] > 0 && arr[nx][ny] != p) {
                    ret = Math.min(ret, chk[x][y]);
                    return;
                }
                
                if(arr[nx][ny] == 0 && chk[nx][ny] == -1) {
                    chk[nx][ny] = chk[x][y]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

}
