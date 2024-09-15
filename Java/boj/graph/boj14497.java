package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14497 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken())-1;
        int y1 = Integer.parseInt(st.nextToken())-1;
        int x2 = Integer.parseInt(st.nextToken())-1;
        int y2 = Integer.parseInt(st.nextToken())-1;
        
        char[][] graph = new char[N][M];
        for(int i=0; i<N; i++) graph[i] = br.readLine().toCharArray();

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x1, y1, 1});

        boolean[][] visited = new boolean[N][M];
        visited[x1][y1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];

            if(x == x2 && y == y2) {
                bw.write(cnt+"");
                break;
            }

            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(graph[nx][ny] == '1') q.addLast(new int[]{nx, ny, cnt+1});
                    else q.addFirst(new int[]{nx, ny, cnt});
                }
            }
        }
    }

}
