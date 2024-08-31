package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj17401 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int mod = 1_000_000_007;
    private static int N;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[][][] arr = new long[T][N][N];

        for(int i=0; i<T; i++) {
            int M = Integer.parseInt(br.readLine());
            for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                arr[i][x-1][y-1] = z;
            }
        }

        long[][] ans = new long[N][N];
        long[][] period = new long[N][N];

        for(int i=0; i<N; i++) {
            ans[i][i] = 1;
            period[i][i] = 1;
        }

        for(int i=0; i<T; i++) {
            period = mul(period, arr[i]);
        }
        
        ans = mul(ans, square(period, D/T));

        for(int i=0; i<D%T; i++) ans = mul(ans, arr[i]);

        sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] ret = new long[N][N];

        for(int i=0; i<N; i++) for(int j=0; j<N; j++) for(int k=0; k<N; k++) {
            ret[i][j] = (ret[i][j]+a[i][k]*b[k][j])%mod;
        }
        
        return ret;
    }

    private static long[][] square(long[][] a, long n) {
        long[][] ret = new long[N][N];
        for(int i=0; i<N; i++) ret[i][i] = 1;

        while(n != 0) {
            if(n%2 == 1) ret = mul(ret, a);
            a = mul(a, a);
            n /= 2;
        }

        return ret;
    }

}
