package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj20046 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dy = {1,-1,0,0}, dx = {0,0,1,-1};

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

        int[][] board = new int[m][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(board[0][0] == -1) {
            bw.write("-1");
            return;
        }

        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        visited[0][0] = board[0][0];

        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0]-o2[0];
                else if(o1[1] != o2[1]) return o1[1]-o2[1];
                return o1[2]-o2[2];
            }
        });

        q.add(new int[]{board[0][0], 0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int t = cur[0], y = cur[1], x = cur[2];
            for(int i=0; i<4; i++) {
                int ny = y+dy[i], nx = x+dx[i];
                if(0 <= ny && ny < m && 0 <= nx && nx < n && board[ny][nx] != -1) {
                    if(visited[ny][nx] > t+board[ny][nx]) {
                        visited[ny][nx] = t+board[ny][nx];
                        q.add(new int[]{visited[ny][nx], ny, nx});
                    }
                }
            }
        }

        bw.write((visited[m-1][n-1] != Integer.MAX_VALUE) ? visited[m-1][n-1]+"" : "-1");
    }

}
