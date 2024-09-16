package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16954 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] dx = {0,0,1,-1,1,-1,1,-1,0};
    private static final int[] dy = {1,-1,0,0,1,1,-1,-1,0};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int n = 8;

        char[][] graph = new char[n][n];
        for(int i=0; i<n; i++) graph[i] = br.readLine().toCharArray();

        boolean[][] visited = new boolean[n][n];
        visited[n-1][0] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n-1, 0});

        int ret = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];

            if(graph[i][j] == '#') continue;

            for(int idx=0; idx<n+1; idx++) {
                int ni = i+dy[idx], nj = j+dx[idx];
                if(ni < 0 || ni >= n || nj < 0 || nj >= n || graph[ni][nj] == '#') continue;

                if(ni == 0) ret = 1;

                if(ni >= 1 && !visited[ni-1][nj]) {
                    visited[ni-1][nj] = true;
                    q.add(new int[]{ni-1, nj});
                }
            }
        }

        bw.write(ret+"");
    }

}
