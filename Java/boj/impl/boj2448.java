package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj2448 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static char[][] ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        ret = new char[n][2*n];
        for(int i=0; i<n; i++) Arrays.fill(ret[i], ' ');

        dfs(0, n-1, n);

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<2*n; j++) sb.append(ret[i][j]);
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static void dfs(int x, int y, int n) {
        if(n == 3) {
            ret[x][y] = '*';
            ret[x+1][y-1] = ret[x+1][y+1] = '*';
            for(int i=-2; i<=2; i++) ret[x+2][y+i] = '*';
            return;
        }

        dfs(x, y, n/2);
        dfs(x+n/2, y-n/2, n/2);
        dfs(x+n/2, y+n/2, n/2);
    }

}
