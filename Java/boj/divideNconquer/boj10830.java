package CodeTest.Java.boj.divideNconquer;

import java.io.*;
import java.util.*;

public class boj10830 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int N, A[][];
    private static long B;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] C = square(A, B);
        sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(C[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static int[][] square(int[][] a, long b) {
        if(b == 1) {
            for(int x=0; x<N; x++) {
                for(int y=0; y<N; y++) {
                    a[x][y] %= 1000;
                }
            }
            return a;
        }
        else {
            int[][] tmp = square(a, b/2);
            return (b%2 == 0) ? mul(tmp, tmp) : mul(mul(tmp, tmp), a);
        }
    }

    private static int[][] mul(int[][] u, int[][] v) {
        int[][] z = new int[N][N];
        for(int row=0; row<N; row++) {
            for(int col=0; col<N; col++) {
                long e = 0;
                for(int i=0; i<N; i++) e += u[row][i]*v[i][col];
                z[row][col] = (int) e%1000;
            }
        }
        return z;
    }

}
