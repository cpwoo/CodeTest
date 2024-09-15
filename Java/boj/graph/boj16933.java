package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16933 {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for(int i=0; i<n; i++) {
            char[] inp = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                graph[i][j] = inp[j]-'0';
            }
        }

        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(visited[i], k+1);
        visited[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});

        int ret = 1;
        boolean time = true;

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int t=0; t<sz; t++) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1], w = cur[2];

                if(i == n-1 && j == m-1) {
                    bw.write(ret+"");
                    return;
                }

                for(int d=0; d<4; d++) {
                    int ni = i+dy[d], nj = j+dx[d];
                    if(ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] <= w) continue;

                    if(graph[ni][nj] == 0) {
                        q.add(new int[]{ni, nj, w});
                        visited[ni][nj] = w;
                    }
                    else if(w < k) {
                        if(!time) q.add(new int[]{i, j, w});
                        else {
                            visited[ni][nj] = w;
                            q.add(new int[]{ni, nj, w+1});
                        }
                    }
                }
            }
            ret++;
            time = !time;
        }

        bw.write("-1");
    }

}
