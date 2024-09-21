package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj17144 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int R, C, arr[][], up, down;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        up = -1; down = -1;

        for(int i=0; i<R; i++) {
            if(arr[i][0] == -1) {
                up = i; down = i+1;
                break;
            }
        }

        for(int i=0; i<T; i++) {
            spread(); airUp(); airDown();
        }

        int ret = 0;
        for(int i=0; i<R; i++) for(int j=0; j<C; j++) {
            if(arr[i][j] > 0) ret += arr[i][j];
        }

        bw.write(ret+"");
    }

    private static void spread() {
        final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
        
        int[][] tmp = new int[R][C];

        for(int i=0; i<R; i++) for(int j=0; j<C; j++) {
            if(arr[i][j] != 0 && arr[i][j] != -1) {
                int t = 0;
                for(int d=0; d<4; d++) {
                    int ni = i+dx[d], nj = j+dy[d];
                    if(0 <= ni && ni < R && 0 <= nj && nj < C && arr[ni][nj] != -1) {
                        tmp[ni][nj] += arr[i][j]/5;
                        t += arr[i][j]/5;
                    }
                }
                arr[i][j] -= t;
            }
        }

        for(int i=0; i<R; i++) for(int j=0; j<C; j++) arr[i][j] += tmp[i][j];
    }

    private static void airUp() {
        final int[] dx = {0,-1,0,1}, dy = {1,0,-1,0};

        int direct = 0, before = 0, x = up, y = 1;

        while(true) {
            int nx = x+dx[direct], ny = y+dy[direct];
            if(x == up && y == 0) break;
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                direct++;
                continue;
            }
            int t = arr[x][y];
            arr[x][y] = before;
            before = t;

            x = nx; y = ny;
        }
    }

    private static void airDown() {
        final int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

        int direct = 0, before = 0, x = down, y = 1;

        while(true) {
            int nx = x+dx[direct], ny = y+dy[direct];
            if(x == down && y == 0) break;
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                direct++;
                continue;
            }
            int t = arr[x][y];
            arr[x][y] = before;
            before = t;

            x = nx; y = ny;
        }
    }

}
