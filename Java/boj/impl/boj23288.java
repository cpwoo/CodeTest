package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj23288 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dice = {1,2,3,4,5,6};
        int x = 0, y = 0, d = 0, ret = 0;
        int tmp;

        for(int move=0; move<k; move++) {
            if(x+dx[d] < 0 || x+dx[d] >= n || y+dy[d] < 0 || y+dy[d] >= m) d = (d+2)%4;

            x += dx[d]; y += dy[d];

            Queue<int[]> q = new ArrayDeque<>();
            int[][] c = new int[n][m];
            c[x][y] = 1;
            q.add(new int[]{x, y});

            int cnt = 0;

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0], cy = cur[1];

                for(int i=0; i<4; i++) {
                    int nx = cx+dx[i], ny = cy+dy[i];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && c[nx][ny] == 0 && arr[nx][ny] == arr[x][y]) {
                        cnt++;
                        c[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            ret += (cnt+1)*arr[x][y];

            switch(d) {
                case 0:
                    tmp = dice[0];
                    dice[0] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = dice[2];
                    dice[2] = tmp;
                    break;
                case 1:
                    tmp = dice[0];
                    dice[0] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = tmp;
                    break;
                case 2:
                    tmp = dice[0];
                    dice[0] = dice[2];
                    dice[2] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = tmp;
                    break;
                case 3:
                    tmp = dice[0];
                    dice[0] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = tmp;
                    break;
            }

            if(dice[5] > arr[x][y]) d = (d+1)%4;
            else if(dice[5] < arr[x][y]) d = (d+3)%4;
        }

        bw.write(ret+"");
    }

}
