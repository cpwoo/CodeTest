package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj14927 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0,0};
    private static final int[] dy = {0,0,0,-1,1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[][] table = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = n*n+1;

        int[][] a;
        for(int f=0; f<(1<<n); f++) {
            a = new int[n][n];
            for(int i=0; i<n; i++) for(int j=0; j<n; j++) a[i][j] = table[i][j];

            int cnt = 0;

            for(int x=0; x<n; x++) {
                if((f&(1<<x)) != 0) {
                    cnt++;
                    for(int k=0; k<5; k++) {
                        int nx = x+dx[k], ny = 0+dy[k];
                        if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                            a[ny][nx] = 1-a[ny][nx];
                        }
                    }
                }
            }

            for(int y=1; y<n; y++) {
                for(int x=0; x<n; x++) {
                    if(a[y-1][x] == 0) continue;
                    for(int k=0; k<5; k++) {
                        int nx = x+dx[k], ny = y+dy[k];
                        if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                            a[ny][nx] = 1-a[ny][nx];
                        }
                    }
                    cnt++;
                }
            }

            boolean flag = true;
            for(int i=0; i<n; i++) if(a[n-1][i] == 1) flag = false;

            if(flag) ret = Math.min(ret, cnt);
        }

        bw.write((ret != n*n+1) ? ret+"" : "-1");
    }
}
