package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj17779 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, data[][], total;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        data = new int[n+1][n+1];
        total = 0;
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                total += data[i][j];
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int x=1; x<n+1; x++) for(int y=1; y<n+1; y++) {
            for(int d1=1; d1<n+1; d1++) for(int d2=1; d2<n+1; d2++) {
                if(x+d1+d2 > n || y-d1 < 1 || y+d2 > n) continue;
                ret = Math.min(ret, diff(x, y, d1, d2));
            }
        }

        bw.write(ret+"");
    }

    private static int diff(int x, int y, int d1, int d2) {
        int[][] tmp = new int[n+1][n+1];
        tmp[x][y] = 5;

        for(int i=1; i<d1+1; i++) tmp[x+i][y-i] = 5;
        for(int i=1; i<d2+1; i++) tmp[x+i][y+i] = 5;
        for(int i=1; i<d2+1; i++) tmp[x+d1+i][y-d1+i] = 5;
        for(int i=1; i<d1+1; i++) tmp[x+d2+i][y+d2-i] = 5;

        int[] cnt = new int[5];

        for(int r=1; r<x+d1; r++) for(int c=1; c<y+1; c++) {
            if(tmp[r][c] == 5) break;
            else cnt[0] += data[r][c];
        }

        for(int r=1; r<x+d2+1; r++) for(int c=n; c>y; c--) {
            if(tmp[r][c] == 5) break;
            else cnt[1] += data[r][c];
        }

        for(int r=x+d1; r<n+1; r++) for(int c=1; c<y-d1+d2; c++) {
            if(tmp[r][c] == 5) break;
            else cnt[2] += data[r][c];
        }

        for(int r=x+d2+1; r<n+1; r++) for(int c=n; c>y-d1+d2-1; c--) {
            if(tmp[r][c] == 5) break;
            else cnt[3] += data[r][c];
        }

        cnt[4] = total-(cnt[0]+cnt[1]+cnt[2]+cnt[3]);

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<5; i++) {
            min = Math.min(min, cnt[i]);
            max = Math.max(max, cnt[i]);
        }

        return max-min;
    }

}
