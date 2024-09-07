package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1245 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,-1,0,0,1,1,-1,-1}, dy = {0,0,1,-1,1,-1,-1,1};

    private static int n, m, graph[][], flag;
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

        visited = new boolean[n][m];

        int ret = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(graph[i][j] > 0 && !visited[i][j]) {
                flag = 1;
                search(i, j);
                ret += flag;
            }
        }

        bw.write(ret+"");
    }

    private static void search(int x, int y) {
        visited[x][y] = true;
        for(int d=0; d<8; d++) {
            int nx = x+dx[d], ny = y+dy[d];
            if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                if(graph[x][y] < graph[nx][ny]) flag = 0;
                if(!visited[nx][ny] && graph[x][y] == graph[nx][ny]) search(nx, ny);
            }
        }
    }

}
