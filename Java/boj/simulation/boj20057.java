package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj20057 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,1,0,-1}, dy = {-1,0,1,0};
    private static final int[][] windx = {
        {-1,1,-2,2,0,-1,1,-1,1},
        {-1,-1,0,0,2,0,0,1,1},
        {1,-1,2,-2,0,1,-1,1,-1},
        {1,1,0,0,-2,0,0,-1,-1}
    };
    private static final int[][] windy = {
        {1,1,0,0,-2,0,0,-1,-1},
        {-1,1,-2,2,0,-1,1,-1,1},
        {-1,-1,0,0,2,0,0,1,1},
        {1,-1,2,-2,0,1,-1,1,-1}
    };
    private static final int[] rate = {1,1,2,2,5,7,7,10,10};

    private static int n, data[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        int x = n/2, y = n/2;

        data = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = 0;
        boolean[][] visited = new boolean[n][n];
        int d = -1;

        while(true) {
            if(x == 0 && y == 0) break;
            visited[x][y] = true;
            int nd = (d+1)%4;
            int nx = x+dx[nd], ny = y+dy[nd];

            if(visited[nx][ny]) {
                nd = d;
                nx = x+dx[nd]; ny = y+dy[nd];
            }
            
            ret += wind(nx, ny, nd);

            x = nx; y = ny; d = nd;
        }

        bw.write(ret+"");
    }

    private static int wind(int x, int y, int d) {
        int val = 0, sand = data[x][y], sum = 0;

        for(int i=0; i<9; i++) {
            int nx = x+windx[d][i], ny = y+windy[d][i];
            int windSand = (sand*rate[i])/100;
            sum += windSand;

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                val += windSand;
                continue;
            }
            else data[nx][ny] += windSand;
        }

        int nx = x+dx[d], ny = y+dy[d];
        int a = sand-sum;

        if(nx < 0 || nx >= n || ny < 0 || ny >= n) val += a;
        else data[nx][ny] += a;

        data[x][y] = 0;

        return val;
    }

}
