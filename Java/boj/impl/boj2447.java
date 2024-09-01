package CodeTest.Java.boj.impl;

import java.io.*;

public class boj2447 {
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
        ret = new char[n][n];

        dfs(0, 0, n, n);

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) sb.append(ret[i][j]);
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static void dfs(int y, int x, int sz, int val) {
        if(val == 0) {
            for(int i=y; i<y+sz; i++) for(int j=x; j<x+sz; j++) {
                ret[i][j] = ' ';
            }
        }
        else if(val == 1) ret[y][x] = '*';
        else {
            int jump = sz/3, num = 0;
            for(int i=y; i<y+sz; i+=jump) for(int j=x; j<x+sz; j+=jump) {
                num++;
                if(num == 5) dfs(i, j, jump, 0);
                else dfs(i, j, jump, jump);
            }
        }
    }

}
