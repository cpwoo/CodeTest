package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj14503 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};

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
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[R][C] = true;

        int cnt = 1;
        while(true) {
            boolean flag = false;
            for(int i=0; i<4; i++) {
                D = (D+3)%4;
                int nx = R+dx[D], ny = C+dy[D];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    cnt++;
                    R = nx; C = ny;
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                if(graph[R-dx[D]][C-dy[D]] == 1) {
                    bw.write(cnt+"");
                    break;
                }
                else {
                    R -= dx[D]; C -= dy[D];
                }
            }
        }
    }
}
