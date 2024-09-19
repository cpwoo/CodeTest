package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj16234 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int N, L, R, graph[][];
    private static boolean visited[][];
    private static List<int[]> tmp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        while(true) {
            visited = new boolean[N][N];
            boolean flag = false;

            for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    tmp = new ArrayList<>();

                    bfs(i, j);

                    if(tmp.size() > 1) {
                        flag = true;
                        int num = 0;
                        for(int[] t : tmp) num += graph[t[0]][t[1]];
                        num /= tmp.size();
                        for(int[] t : tmp) graph[t[0]][t[1]] = num;
                    }
                }
            }
            if(!flag) break;
            cnt++;
        }

        bw.write(cnt+"");
    }

    private static void bfs(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        tmp.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(graph[nx][ny]-graph[x][y]);
                    if(L <= diff && diff <= R) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        tmp.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}
