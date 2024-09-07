package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1405 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    private static int N;
    private static boolean graph[][];
    private static double percentData[], ret;

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

        percentData = new double[4];
        for(int i=0; i<4; i++) percentData[i] = Double.parseDouble(st.nextToken());

        graph = new boolean[2*N+1][2*N+1];

        ret = 0;

        dfs(N, N, 1, 0);

        bw.write(ret+"");
    }

    private static void dfs(int x, int y, double percent, int cnt) {
        if(cnt == N) {
            ret += percent;
            return;
        }

        double cur = percent;
        graph[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(0 <= nx && nx < 2*N+1 && 0 <= ny && ny < 2*N+1) {
                if(graph[nx][ny]) continue;
                dfs(nx, ny, cur*(percentData[i]/100), cnt+1);
                graph[nx][ny] = false;
            }
        }
    }

}
