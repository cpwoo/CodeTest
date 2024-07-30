package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj3108 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};

    private static boolean a[][], c[][];
    private static Deque<int[]> q;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        a = new boolean[2001][2001];
        c = new boolean[2001][2001];

        int[][] start = new int[n][2];
        for(int idx=0; idx<n; idx++) {
            st = new StringTokenizer(br.readLine());
            int x1 = (Integer.parseInt(st.nextToken())+500)*2;
            int y1 = (Integer.parseInt(st.nextToken())+500)*2;
            int x2 = (Integer.parseInt(st.nextToken())+500)*2;
            int y2 = (Integer.parseInt(st.nextToken())+500)*2;
            
            start[idx][0] = x1; start[idx][1] = y1;

            for(int i=x1; i<x2+1; i++) {
                if(i == x1 || i == x2) {
                    for(int j=y1; j<y2+1; j++) {
                        a[i][j] = true;
                    }
                }
                else {
                    a[i][y1] = a[i][y2] = true;
                }
            }
        }
        q = new ArrayDeque<>();
        int ret = 0;
        for(int i=0; i<n; i++) {
            int x = start[i][0], y = start[i][1];
            if(!c[x][y]) {
                bfs(x, y);
                ret++;
            }
        }

        if(a[1000][1000]) ret--;

        bw.write(ret+"");
    }

    private static void bfs(int x, int y) {
        q.add(new int[]{x, y});
        c[x][y] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d=0; d<4; d++) {
                int nx = cur[0]+dx[d], ny = cur[1]+dy[d];
                if(0 <= nx && nx <= 2000 && 0 <= ny && ny <= 2000) {
                    if(a[nx][ny] && !c[nx][ny]) {
                        c[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}
