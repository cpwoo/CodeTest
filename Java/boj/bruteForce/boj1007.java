package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj1007 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, coords[][];
    private static double ret;
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            coords = new int[n][2];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<2; j++) {
                    coords[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ret = Double.MAX_VALUE;
            v = new boolean[n];

            combination(0, n/2);

            bw.write(ret+"\n");
        }
    }

    private static void combination(int idx, int cnt) {
        if(cnt == 0) ret = Math.min(ret, sum());
        else {
            for(int i=idx; i<n; i++) {
                v[i] = true;
                combination(i+1, cnt-1);
                v[i] = false;
            }
        }
    }

    private static double sum() {
        int x = 0, y = 0;
        for(int i=0; i<n; i++) {
            if(v[i]) {
                x += coords[i][0];
                y += coords[i][1];
            } else {
                x -= coords[i][0];
                y -= coords[i][1];
            }
        }
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

}
