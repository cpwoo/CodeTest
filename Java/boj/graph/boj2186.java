package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2186 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, k, visited[][][];
    private static char arr[][], word[];

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
        k = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();

        word = br.readLine().toCharArray();

        int ret = 0;

        visited = new int[n][m][word.length];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            Arrays.fill(visited[i][j], -1);
        }

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(arr[i][j] == word[0]) ret += dfs(i, j, 1);
        }

        bw.write(ret+"");
    }

    private static int dfs(int x, int y, int idx) {
        if(idx == word.length) return 1;

        if(visited[x][y][idx] != -1) return visited[x][y][idx];

        visited[x][y][idx] = 0;

        for(int d=0; d<4; d++) {
            int tx = x, ty = y;
            for(int i=0; i<k; i++) {
                int nx = tx+dx[d], ny = ty+dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(arr[nx][ny] == word[idx]) {
                        visited[x][y][idx] += dfs(nx, ny, idx+1);
                    }
                }
                tx = nx; ty = ny;
            }
        }

        return visited[x][y][idx];
    }

}
