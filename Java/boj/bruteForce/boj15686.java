package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj15686 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, ret, idx1, idx2;
    private static int[][] x = new int[2501][2];
    private static int[][] y = new int[2501][2];
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        idx1 = 0; idx2 = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t == 1) {
                    x[idx1][0] = i; x[idx1++][1] = j;
                } else if(t == 2) {
                    y[idx2][0] = i; y[idx2++][1] = j;
                }
            }
        }

        ret = Integer.MAX_VALUE;
        v = new boolean[idx2];

        dfs(0, 0);

        bw.write(ret+"");
    }

    private static void dfs(int start, int cnt) {
        if(cnt == m) {
            int tmp = 0;
            for(int i=0; i<idx1; i++) {
                int _min = Integer.MAX_VALUE;
                for(int j=0; j<idx2; j++) {
                    if(v[j]) {
                        int dist = Math.abs(x[i][0]-y[j][0])+Math.abs(x[i][1]-y[j][1]);
                        _min = Math.min(_min, dist);
                    }
                }
                tmp += _min;
            }
            ret = Math.min(ret, tmp);
            return;
        }

        for(int i=start; i<idx2; i++) {
            v[i] = true;
            dfs(i+1, cnt+1);
            v[i] = false;
        }
    }

}
