package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2206 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n, m, visited[][][];
    private static char arr[][];

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

        arr = new char[n][m];
        for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();

        visited = new int[n][m][2];
        visited[0][0][0] = 1;

        bw.write(bfs(0, 0, 0)+"");
    }

    private static int bfs(int x, int y, int z) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, z});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1], c = cur[2];

            if(a == n-1 && b == m-1) return visited[a][b][c];

            for(int i=0; i<4; i++) {
                int nx = a+dx[i], ny = b+dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(arr[nx][ny] == '1' && c == 0) {
                    visited[nx][ny][1] = visited[a][b][0]+1;
                    q.add(new int[]{nx, ny, 1});
                }
                else if(arr[nx][ny] == '0' && visited[nx][ny][c] == 0) {
                    visited[nx][ny][c] = visited[a][b][c]+1;
                    q.add(new int[]{nx, ny, c});
                }
            }
        }

        return -1;
    }

}
