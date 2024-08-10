package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj16974 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static long hb[], p[];

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
        long x = Long.parseLong(st.nextToken());

        hb = new long[n+1];
        p = new long[n+1];

        hb[0] = 1; p[0] = 1;

        for(int i=1; i<n+1; i++) {
            hb[i] = 1+hb[i-1]+1+hb[i-1]+1;
            p[i] = p[i-1]+1+p[i-1];
        }

        bw.write(cnt(n, x)+"");
    }
    
    private static long cnt(int N, long X) {
        if(X == 1) return 0;

        if(X < hb[N-1]+1) return cnt(N-1, X-1);

        if(X == hb[N-1]+1) return p[N-1];

        if(X == hb[N-1]+2) return p[N-1]+1;

        if(X < 2*hb[N-1]+2) return p[N-1]+1+cnt(N-1, X-(hb[N-1]+2));

        return p[N];
    }

}
