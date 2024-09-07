package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1113 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, board[][];
    private static boolean visited[][];

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

        board = new int[n][m];
        for(int i=0; i<n; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                board[i][j] = inp[j]-'0';
            }
        }
    
        int ret = 0;
        for(int num=1; num<9; num++) {
            visited = new boolean[n][m];
            for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                if(board[i][j] <= num && !visited[i][j]) {
                    ret += bfs(i, j, num);
                }
            }
        }

        bw.write(ret+"");
    }

    private static int bfs(int i, int j, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        visited[i][j] = true;

        boolean flag = true; int cnt = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(nx == -1 || nx == n || ny == -1 || ny == m) {
                    flag = false;
                    continue;
                }
                if(board[nx][ny] <= num && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    cnt++;
                }
            }
        }

        return (flag) ? cnt : 0;
    }

}
