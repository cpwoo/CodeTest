package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2573 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, graph[][], tmp[][];
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

        graph = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        int ret = 1;

        while(true) {
            visited = new boolean[n][m];
            int piece = 0;
            boolean flag = true;

            for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                if(graph[i][j] != 0) flag = false;
            }

            if(flag) {
                bw.write("0");
                break;
            }

            tmp = new int[n][m];
            for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                tmp[i][j] = graph[i][j];
            }

            for(int i=1; i<n-1; i++) for(int j=1; j<m-1; j++) {
                if(tmp[i][j] != 0) {
                    graph[i][j] = Math.max(0, graph[i][j]-countOcean(i, j));
                }
            }

            for(int i=1; i<n-1; i++) for(int j=1; j<m-1; j++) {
                if(!visited[i][j] && graph[i][j] != 0) {
                    countIceberg(i, j);
                    piece++;
                }
            }

            if(piece >= 2) {
                bw.write(ret+"");
                break;
            }

            ret++;
        }
    }

    private static int countOcean(int x, int y) {
        int cnt = 0;

        for(int i=0; i<4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(0 <= nx && nx < n && 0 <= ny && ny < m && tmp[nx][ny] == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void countIceberg(int startX, int startY) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < m && graph[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

}
