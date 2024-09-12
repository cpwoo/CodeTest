package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj5547 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[][] dx = {{1,0,-1,-1,-1,0},{1,1,0,-1,0,1}};
    private static final int[] dy = {0,1,1,0,-1,-1};

    private static int w, h, matrix[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        matrix = new int[h+2][w+2];
        for(int i=1; i<h+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<w+1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs(0, 0)+"");
    }

    private static int bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});

        boolean[][] visited = new boolean[h+2][w+2];
        visited[y][x] = true;

        int cnt = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];
            for(int i=0; i<6; i++) {
                int nx = cx+dx[cy%2][i], ny = cy+dy[i];
                if(0 <= nx && nx < w+2 && 0 <= ny && ny < h+2) {
                    if(matrix[ny][nx] == 0 && !visited[ny][nx]) {
                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                    else if(matrix[ny][nx] == 1) cnt++;
                }
            }
        }

        return cnt;
    }

}
