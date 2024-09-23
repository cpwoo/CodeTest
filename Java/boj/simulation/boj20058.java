package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj20058 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};

    private static int n, ice[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = 1<<(Integer.parseInt(st.nextToken()));
        int q = Integer.parseInt(st.nextToken());

        ice = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(q-- > 0) {
            int k = 1<<(Integer.parseInt(st.nextToken()));
            for(int x=0; x<n; x+=k) for(int y=0; y<n; y+=k) {
                int[][] tmp = new int[k][k];
                for(int i=x; i<x+k; i++) for(int j=y; j<y+k; j++) {
                    tmp[i-x][j-y] = ice[i][j];
                }
                for(int i=0; i<k; i++) for(int j=0; j<k; j++) {
                    ice[x+j][y+k-1-i] = tmp[i][j];
                }
            }

            int[][] cnt = new int[n][n];
            for(int x=0; x<n; x++) for(int y=0; y<n; y++) {
                for(int d=0; d<4; d++) {
                    int nx = x+dx[d], ny = y+dy[d];
                    if(0 <= nx && nx < n && 0 <= ny && ny < n && ice[nx][ny] > 0) {
                        cnt[x][y]++;
                    }
                }
            }

            for(int x=0; x<n; x++) for(int y=0; y<n; y++) {
                if(ice[x][y] > 0 && cnt[x][y] < 3) ice[x][y]--;
            }
        }

        int sum = 0;
        for(int x=0; x<n; x++) for(int y=0; y<n; y++) sum += ice[x][y];

        int ret = 0;
        for(int x=0; x<n; x++) for(int y=0; y<n; y++) {
            if(ice[x][y] > 0) ret = Math.max(ret, dfs(x, y));
        }

        bw.write(sum+"\n"+ret+"");
    }

    private static int dfs(int x, int y) {
        int val = 1;
        ice[x][y] = 0;
        for(int d=0; d<4; d++) {
            int nx = x+dx[d], ny = y+dy[d];
            if(0 <= nx && nx < n && 0 <= ny && ny < n && ice[nx][ny] > 0) {
                val += dfs(nx, ny);
            }
        }
        return val;
    }

}
