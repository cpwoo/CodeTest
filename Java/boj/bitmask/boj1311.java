package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj1311 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, tasks[][], v[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        tasks = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                tasks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        v = new int[n][1<<n];
        for(int i=0; i<n; i++) {
            Arrays.fill(v[i], -1);
        }

        bw.write(dfs(0, 0)+"");
    }

    private static int dfs(int row, int visit) {
        if(row == n) return 0;

        if(v[row][visit] != -1) return v[row][visit];

        int ret = 1000000000;
        for(int i=0; i<n; i++) {
            if((visit&(1<<i)) != 0) continue;
            ret = Math.min(ret, dfs(row+1, (visit|(1<<i)))+tasks[row][i]);
        }

        return v[row][visit] = ret;
    }

}
